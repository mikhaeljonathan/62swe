const express = require('express');
const cors = require('cors');
const { v4: uuidv4 } = require('uuid');
const bcrypt = require('bcrypt');
const saltRounds = 10;

const postGresClient = require('./postgres.js');
const redisClient = require('./redis.js');

const app = express();
const corsOptions = {
    origin: 'http://localhost:5173',
    credentials: true
};
app.use(cors(corsOptions));

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

async function validateCookie (req, res, next) {
    const cookies = req.headers.cookie ? req.headers.cookie : "";
    // split the cookies by ;
    const cookieArray = cookies.split(';');

    // search the cookieArray with the key = sessionId
    let sessionId = '';
    cookieArray.forEach(cookie => {
        if (cookie.trim().startsWith('sessionId')) {
            sessionId = cookie.split('=')[1];
        }
    });

    if (sessionId === "") next();

    const username = await redisClient.get(sessionId);

    if (username && username.length != 0) {
        req.authenticated = true;
    }

    next();
}

app.get('/cookie/validation', validateCookie);

app.get('/cookie/validation', async (req, res) => {
    if (req.authenticated) {
        res.status(200).send('Session is valid')
    } else {
        res.status(400).send('Session is not valid');
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

        const uuid = uuidv4();
        // add uuid to redis
        await redisClient.set(uuid, username, {
            EX: 60 * 60 * 24 * 7
        });

        res.cookie('sessionId', uuid, {
            httpOnly: true,
            maxAge: 1000 * 60 * 60 * 24 * 7
        });

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
        
        const uuid = uuidv4();
        // add uuid to redis
        await redisClient.set(uuid, result.rows[0].username, {
            EX: 60 * 60 * 24 * 7
        });

        res.cookie('sessionId', uuid, {
            httpOnly: true,
            maxAge: 1000 * 60 * 60 * 24 * 7
        });
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

app.get('/logout', async (req, res) => {
    const cookies = req.headers.cookie ? req.headers.cookie : "";
    // split the cookies by ;
    const cookieArray = cookies.split(';');

    // search the cookieArray with the key = sessionId
    let sessionId = '';
    cookieArray.forEach(cookie => {
        if (cookie.trim().startsWith('sessionId')) {
            sessionId = cookie.split('=')[1];
        }
    });

    if (sessionId === "") {
        res.status(400).send('No session found');
        return;
    }

    await redisClient.del(sessionId);

    res.clearCookie('sessionId');
    res.status(200).send('Logged out');
});

if (process.env.NODE_ENV !== 'test') {
    app.listen(3000, () => {
        console.log('Server is running on port 3000');
    });
}

module.exports = {
    validateCookie
}