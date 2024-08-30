package sixtytwo.swe.loggingdemo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LevelTest {

    private static final Logger log = LoggerFactory.getLogger(LevelTest.class);

    @Test
    public void testLevel() {
        log.trace("Entering function validateUser() with parameters: username='john_doe', password='*****");
        log.debug("User input received: {'username': 'john_doe', 'action': 'login'}");
        log.info("Server started on port 8080");
        log.warn("Disk space is running low on /dev/sda1");
        log.error("Failed to connect to database: Connection refused");
        log.error("CRITICAL: System out of memory, initiating shutdown");
    }

    @Test
    public void testLogFileBig() {
        for (int i = 0; i < 100000; i++) {
            log.trace("Entering function validateUser() with parameters: username='john_doe', password='*****");
            log.debug("User input received: {'username': 'john_doe', 'action': 'login'}");
            log.info("Server started on port 8080");
            log.warn("Disk space is running low on /dev/sda1");
            log.error("Failed to connect to database: Connection refused");
            log.error("CRITICAL: System out of memory, initiating shutdown");
        }
    }
}
