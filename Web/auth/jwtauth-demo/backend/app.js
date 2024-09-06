const express = require('express');
const jwt = require('jsonwebtoken');
const cors = require('cors');
const { Client } = require('pg');
const bcrypt = require('bcrypt');
const saltRounds = 10;

const app = express();
const corsOptions = {
    origin: 'http://localhost:5173',
    credentials: true
};
app.use(cors(corsOptions));

// don't forget to create the user login table first
const postGresClient = new Client({
    user: 'postgres',
    host: 'localhost',
    database: 'kilogramdb',
    password: '1q2w3e4r',
    port: 5432,
});
postGresClient.connect()
    .then(() => console.log('Connected to PostgreSQL'))
    .catch(err => console.error('Connection error', err.stack));

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// remember to put the value of the secret key in the .env file
const secretKey = 'secretKey';

async function validateCookie (req, res, next) {
    let token = req.headers.authorization ? req.headers.authorization : "";

    if (token === "") next();

    token = token.split(' ')[1];

    try {
        const decoded = jwt.verify(token, secretKey);
        console.log("user " + decoded.username + " is authenticated");
        req.authenticated = true;
    } catch (err) {
        next();
    }

    next();
}

app.get('/cookie/validation', validateCookie);

app.get('/cookie/validation', async (req, res) => {
    if (req.authenticated) {
        res.status(200).send('JWT is valid')
    } else {
        res.status(400).send('JWT is not valid');
    }
});

app.post('/signup', async (req, res) => {
    const { username, password } = req.body;
    // hash password
    
    const hashedPassword = await bcrypt.hash(password, saltRounds);

    const query = 'SELECT * FROM users WHERE username = $1';
    const queryValues = [username];
    const postgresResult = await postGresClient.query(query, queryValues);

    if (postgresResult.rows.length > 0) {
        res.status(400).send('Username already exists');
        return;
    }

    const insertQuery = 'INSERT INTO users (username, password) VALUES ($1, $2)';
    const insertQueryValues = [username, hashedPassword];

    postGresClient.query(insertQuery, insertQueryValues, async (err, result) => {
        if (err) {
            res.status(500).send(err);
            return;
        }

        const token = jwt.sign({ username: username }, secretKey, { expiresIn: '1h' });
        res.cookie('token', token);
        res.status(201).send('User created');
    });
})


app.post('/login', async (req, res) => {
    const { username, password } = req.body;

    const query = 'SELECT * FROM users WHERE username = $1';
    const values = [username];
    
    postGresClient.query(query, values, async (err, result) => {
        if (err) {
            res.status(500).send(err);
            return;
        }

        if (result.rows.length === 0) {
            res.status(401).send('Invalid username or password');
            return;
        }

        if (!await bcrypt.compare(password, result.rows[0].password)) {
            res.status(401).send('Invalid username or password');
            return;
        }
        
        const token = jwt.sign({ username: username }, secretKey, { expiresIn: '1h' });
        res.cookie('token', token);
        res.status(200).send('Login successful');
    })
});

app.get("/content", validateCookie);

app.get("/content", (req, res) => {
    if (req.authenticated) {
        res.status(200).send('Content')
    } else {
        res.status(400).send('Not authenticated');
    }
})

app.get('/logout', validateCookie);

app.get('/logout', async (req, res) => {
    if (req.authenticated) {
        res.clearCookie('token');
        res.status(200).send('Session is valid')
    } else {
        res.status(400).send('JWT is not valid');
    }
});

app.listen(3000, () => {
    console.log('Server is running on port 3000');
});