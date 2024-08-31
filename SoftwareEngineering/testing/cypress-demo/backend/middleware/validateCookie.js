const jwt = require('jsonwebtoken');
const { secretKey } = require('../config/config');

const validateCookie = (req, res, next) => {
    let token = req.headers.authorization ? req.headers.authorization : "";

    if (token === "") {
        res.status(400).send('JWT is not valid');
        return;
    }

    token = token.split(' ')[1];

    try {
        const decoded = jwt.verify(token, secretKey);
        console.log("user " + decoded.username + " is authenticated");
        req.authenticated = true;
    } catch (err) {
        res.status(400).send('JWT is not valid');
        return;
    }

    next();
};

module.exports = validateCookie;
