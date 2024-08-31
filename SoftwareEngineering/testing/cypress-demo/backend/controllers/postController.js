const { postGresClient } = require('../db/postgresClient');

exports.insertPost = async (req, res) => {
    const { imageURL, username } = req.body;

    const query = 'INSERT INTO posts (imageurl, username) VALUES ($1, $2) RETURNING *';
    const values = [imageURL, username];
    
    try {
        const result = await postGresClient.query(query, values);
        console.log('Post inserted:', result.rows[0]);
        res.status(201).send('Post created');
    } catch (err) {
        console.error('Error inserting post', err.stack);
        res.status(500).send('Error inserting post');
    }
};

exports.fetchPosts = async (req, res) => {
    const query = 'SELECT * FROM posts';
    
    try {
        const result = await postGresClient.query(query);
        res.status(200).json(result.rows);
    } catch (err) {
        console.error('Error fetching posts', err.stack);
        res.status(500).send('Error fetching posts');
    }
};
