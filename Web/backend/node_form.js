const http = require('http');
const fs = require('fs');
const path = require('path');
const querystring = require('querystring');

// Helper function to serve the HTML form
const serveForm = (res) => {
    fs.readFile(path.join(__dirname, 'node_form.html'), (err, data) => {
        if (err) {
            res.writeHead(500, { 'Content-Type': 'text/plain' });
            res.end('Internal Server Error');
            return;
        }
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end(data);
    });
};

// Create the server
const server = http.createServer((req, res) => {
    if (req.method === 'GET' && req.url === '/') {
        serveForm(res);
    } else if (req.method === 'POST' && req.url === '/submit') {
        let body = '';

        // Collect the form data
        req.on('data', chunk => {
            body += chunk.toString();
        });

        // Process the form data
        req.on('end', () => {
            const parsedData = querystring.parse(body);
            const name = parsedData.name;
            const email = parsedData.email;

            if (name && email) {
                res.writeHead(200, { 'Content-Type': 'text/html' });
                res.end(`
                    <h2>Form Data Submitted Successfully</h2>
                    <p><strong>Name:</strong> ${name}</p>
                    <p><strong>Email:</strong> ${email}</p>
                `);
            } else {
                res.writeHead(400, { 'Content-Type': 'text/html' });
                res.end('<p>Please fill in all fields.</p>');
            }
        });
    } else {
        res.writeHead(404, { 'Content-Type': 'text/plain' });
        res.end('Not Found');
    }
});

// Start the server
const PORT = 3000;
server.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}/`);
});

