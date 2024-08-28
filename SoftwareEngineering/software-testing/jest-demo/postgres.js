const { Client } = require('pg');

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

module.exports = postGresClient;