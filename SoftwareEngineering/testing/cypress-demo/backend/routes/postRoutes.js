const express = require('express');
const postController = require('../controllers/postController');
const validateCookie = require('../middleware/validateCookie');

const router = express.Router();

router.post('/posts', validateCookie, postController.insertPost);
router.get('/posts', validateCookie, postController.fetchPosts);

module.exports = router;
