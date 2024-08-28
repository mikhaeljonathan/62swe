const redis = require('redis');

const redisClient = redis.createClient({
    host: 'localhost',
    port: 6379
});
redisClient.connect().catch(console.error);

module.exports = redisClient;