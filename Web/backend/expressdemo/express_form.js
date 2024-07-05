const express = require('express');
const bodyParser = require('body-parser');
const path = require('path');

const app = express();
const port = 3000;

// Middleware to parse form data
app.use(bodyParser.urlencoded({ extended: true }));

// Serve static files from the 'public' directory
app.use(express.static(path.join(__dirname, 'public')));

// Route to handle form submission
app.post('/submit', (req, res) => {
    const name = req.body.name;
    const email = req.body.email;

    if (name && email) {
        res.send(`
            <h2>Form Data Submitted Successfully</h2>
            <p><strong>Name:</strong> ${name}</p>
            <p><strong>Email:</strong> ${email}</p>
        `);
    } else {
        res.send('<p>Please fill in all fields.</p>');
    }
});

app.get('/users/:userId/books/:bookId', (req, res) => {
    res.send(req.params)
});

// Start the server
app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}/`);
});

