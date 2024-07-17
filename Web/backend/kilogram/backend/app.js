const { Client } = require('pg');
const express = require('express');
const cors = require('cors');

const app = express();
const port = 5000;

// allow all CORS requests
const corsOptions = {
    origin: '*'
};

app.use(cors(corsOptions));

// Create a new PostgreSQL client
const client = new Client({
    user: 'postgres',
    host: 'localhost',
    database: 'kilogramdb',
    password: '1q2w3e4r',
    port: 5432,
});

// Connect to the PostgreSQL database
client.connect()
    .then(() => console.log('Connected to PostgreSQL'))
    .catch(err => console.error('Connection error', err.stack));

// Function to insert a new post
const insertPost = async (imageURL, username) => {
    const query = 'INSERT INTO posts (imageurl, username) VALUES ($1, $2) RETURNING *';
    const values = [imageURL, username];
    
    try {
        const res = await client.query(query, values);
        console.log('Post inserted:', res.rows[0]);
    } catch (err) {
        console.error('Error inserting post', err.stack);
    }
};

// Function to fetch all posts
const fetchPosts = async () => {
    const query = 'SELECT * FROM posts';
    
    try {
        const res = await client.query(query);
        // console.log('Posts:', res.rows);
        return res.rows;
    } catch (err) {
        console.error('Error fetching posts', err.stack);
    }
};

app.get("/posts", async (req, res) => {
    const posts = await fetchPosts();
    res.json(posts);
});

app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}/`);
});