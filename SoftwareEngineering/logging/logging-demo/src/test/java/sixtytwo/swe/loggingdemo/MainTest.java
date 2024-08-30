package sixtytwo.swe.loggingdemo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainTest {

    private static final Logger log = LoggerFactory.getLogger(MainTest.class);

    @Test
    public void testLog() {
        log.info("Hello world");
        System.out.println("Hello world");
    }
}
