const express = require('express');
const bodyParser = require('body-parser');
const swaggerUi = require('swagger-ui-express');
const swaggerJsdoc = require('swagger-jsdoc');

const app = express();
const PORT = 3000;

// Middleware to parse JSON bodies
app.use(bodyParser.json());

// Swagger setup
const swaggerOptions = {
    swaggerDefinition: {
      openapi: '3.0.0',
      info: {
        title: 'REST API Example',
        version: '1.0.0',
        description: 'A simple REST API example with Node.js and Express'
      },
      servers: [
        {
          url: 'http://localhost:3000',
          description: 'Local server'
        }
      ]
    },
    apis: ['./server.js']
  };

const swaggerDocs = swaggerJsdoc(swaggerOptions);
app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerDocs));

// Serve Swagger JSON
app.get('/swagger.json', (req, res) => {
    res.setHeader('Content-Type', 'application/json');
    res.send(swaggerDocs);
});

// Sample data
let items = [
    { id: 1, name: 'Item 1' },
    { id: 2, name: 'Item 2' },
];

/**
 * @swagger
 * /items:
 *   get:
 *     summary: Retrieve a list of items
 *     responses:
 *       200:
 *         description: A list of items
 *         content:
 *           application/json:
 *             schema:
 *               type: array
 *               items:
 *                 type: object
 *                 properties:
 *                   id:
 *                     type: integer
 *                     description: The item ID
 *                     example: 1
 *                   name:
 *                     type: string
 *                     description: The item name
 *                     example: Item 1
 */

// GET request to fetch all items
app.get('/items', (req, res) => {
    res.json(items);
});

/**
 * @swagger
 * /items:
 *   post:
 *     summary: Create a new item
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               name:
 *                 type: string
 *                 description: The item name
 *                 example: New Item
 *     responses:
 *       201:
 *         description: The created item
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 id:
 *                   type: integer
 *                   description: The item ID
 *                   example: 3
 *                 name:
 *                   type: string
 *                   description: The item name
 *                   example: New Item
 */

// POST request to create a new item
app.post('/items', (req, res) => {
    const newItem = { id: items.length + 1, ...req.body };
    items.push(newItem);
    res.status(201).json(newItem);
});

/**
 * @swagger
 * /items/{id}:
 *   put:
 *     summary: Update an existing item
 *     parameters:
 *       - in: path
 *         name: id
 *         schema:
 *           type: integer
 *         required: true
 *         description: The item ID
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               name:
 *                 type: string
 *                 description: The item name
 *                 example: Updated Item
 *     responses:
 *       200:
 *         description: The updated item
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 id:
 *                   type: integer
 *                   description: The item ID
 *                   example: 1
 *                 name:
 *                   type: string
 *                   description: The item name
 *                   example: Updated Item
 *       404:
 *         description: Item not found
 */

// PUT request to update an existing item
app.put('/items/:id', (req, res) => {
    const id = parseInt(req.params.id);
    const index = items.findIndex(item => item.id === id);

    if (index !== -1) {
        items[index] = { id, ...req.body };
        res.json(items[index]);
    } else {
        res.status(404).json({ message: 'Item not found' });
    }
});

/**
 * @swagger
 * /items/{id}:
 *   patch:
 *     summary: Partially update an existing item
 *     parameters:
 *       - in: path
 *         name: id
 *         schema:
 *           type: integer
 *         required: true
 *         description: The item ID
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               name:
 *                 type: string
 *                 description: The item name
 *                 example: Partially Updated Item
 *     responses:
 *       200:
 *         description: The partially updated item
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 id:
 *                   type: integer
 *                   description: The item ID
 *                   example: 1
 *                 name:
 *                   type: string
 *                   description: The item name
 *                   example: Partially Updated Item
 *       404:
 *         description: Item not found
 */

// PATCH request to partially update an existing item
app.patch('/items/:id', (req, res) => {
    const id = parseInt(req.params.id);
    const index = items.findIndex(item => item.id === id);

    if (index !== -1) {
        items[index] = { ...items[index], ...req.body };
        res.json(items[index]);
    } else {
        res.status(404).json({ message: 'Item not found' });
    }
});

// Start the server
app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});
