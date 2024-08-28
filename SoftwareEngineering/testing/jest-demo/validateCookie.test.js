const { validateCookie } = require('./app.js');

// Mock PostgreSQL and Redis clients, called before importing 
// the module using hoisting
jest.mock('pg', () => {
    return {
        Client: jest.fn().mockImplementation(() => {
            return {
                connect: jest.fn().mockResolvedValue(true),
                query: jest.fn(),
                end: jest.fn()
            };
        })
    };
});

jest.mock('redis', () => {
    return {
        createClient: jest.fn().mockImplementation(() => {
            return {
                connect: jest.fn().mockResolvedValue(true),
                get: jest.fn(),
                set: jest.fn(),
                del: jest.fn(),
                quit: jest.fn()
            };
        })
    };
});

const redisClient = require('./redis.js');



describe('validateCookie middleware', () => {
    let mockReq, mockRes, mockNext;

    beforeEach(() => {
        // Mock request, response, and next middleware
        mockReq = {
            headers: {
                cookie: 'sessionId=1234'
            }
        };
        mockRes = {};
        mockNext = jest.fn();
    });

    afterEach(() => {
        // Clear all mocks after each test to ensure no shared state
        jest.clearAllMocks();
    });

    test('should set req.authenticated to true if sessionId is valid', async () => {
        redisClient.get.mockResolvedValueOnce('testuser');

        // Call the validateCookie function with the mocked Redis client
        await validateCookie(mockReq, mockRes, mockNext);

        // Assert that req.authenticated is set to true
        expect(mockReq.authenticated).toBe(true);

        // Ensure next middleware is called
        expect(mockNext).toHaveBeenCalled();
    });

    test('should not set req.authenticated if sessionId is not found in Redis', async () => {
        // Mock Redis to return null for the sessionId
        redisClient.get.mockResolvedValueOnce(null);

        // Call the validateCookie function with the mocked Redis client
        await validateCookie(mockReq, mockRes, mockNext);

        // Assert that req.authenticated is not set
        expect(mockReq.authenticated).toBeUndefined();

        // Ensure next middleware is called
        expect(mockNext).toHaveBeenCalled();
    });

    test('should call next without setting authenticated if no sessionId is present', async () => {
        // Mock the request with no sessionId in the cookies
        mockReq.headers.cookie = '';

        // Call the validateCookie function with the mocked Redis client
        await validateCookie(mockReq, mockRes, mockNext);

        // Assert that req.authenticated is not set
        expect(mockReq.authenticated).toBeUndefined();
        // Ensure next middleware is called
        expect(mockNext).toHaveBeenCalled();
    });
});