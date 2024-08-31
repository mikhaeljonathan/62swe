require('dotenv').config();

module.exports = {
    secretKey: process.env.SECRET_KEY || 'secretKey',
    saltRounds: 10,
    corsOptions: {   
        origin: 'http://localhost:5173',
        credentials: true
    },
    PORT: process.env.PORT || 3000,
};
