const express = require('express');
const authController = require('../controllers/authController');
const validateCookie = require('../middleware/validateCookie');

const router = express.Router();

router.post('/signup', authController.signup);
router.post('/login', authController.login);
router.get('/logout', validateCookie, authController.logout);

module.exports = router;
