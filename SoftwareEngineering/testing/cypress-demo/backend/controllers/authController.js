const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const { postGresClient } = require('../db/postgresClient');
const { secretKey, saltRounds } = require('../config/config');

exports.signup = async (req, res) => {
    const { username, password } = req.body;
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

    try {
        await postGresClient.query(insertQuery, insertQueryValues);
        const token = jwt.sign({ username: username }, secretKey, { expiresIn: '1h' });
        res.cookie('token', token);
        res.status(201).send('User created');
    } catch (err) {
        res.status(500).send(err);
    }
};

exports.login = async (req, res) => {
    const { username, password } = req.body;

    const query = 'SELECT * FROM users WHERE username = $1';
    const values = [username];
    
    try {
        const result = await postGresClient.query(query, values);

        if (result.rows.length === 0 || !await bcrypt.compare(password, result.rows[0].password)) {
            res.status(401).send('Invalid username or password');
            return;
        }
        
        const token = jwt.sign({ username: username }, secretKey, { expiresIn: '1h' });
        res.cookie('token', token);
        res.status(200).send('Login successful');
    } catch (err) {
        res.status(500).send(err);
    }
};

exports.logout = (req, res) => {
    res.clearCookie('token');
    res.status(200).send('Logged out');
};
