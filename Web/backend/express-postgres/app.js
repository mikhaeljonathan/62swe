const { Client } = require('pg');

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
        console.log('Posts:', res.rows);
    } catch (err) {
        console.error('Error fetching posts', err.stack);
    }
};

// Insert a new post and fetch all posts (for demonstration)
insertPost('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRh1YlJitFykKDTkmPW1Y4aUsV0TM3ThClA8A&s', 'luffy')
    .then(() => fetchPosts())
    .finally(() => client.end());

