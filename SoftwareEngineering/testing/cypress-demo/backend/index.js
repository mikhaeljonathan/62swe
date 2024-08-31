const express = require('express');
const cors = require('cors');
const authRoutes = require('./routes/authRoutes');
const postRoutes = require('./routes/postRoutes');
const { corsOptions, PORT } = require('./config/config');

const app = express();
app.use(cors(corsOptions));
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.use(authRoutes);
app.use(postRoutes);

app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});