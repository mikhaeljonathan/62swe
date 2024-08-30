package sixtytwo.swe.loggingdemo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class StructuredTest {

    private static final Logger log = LoggerFactory.getLogger(StructuredTest.class);

    @Test
    public void  testStructured() {
        MDC.put("userId", "12345");
        log.info("Performing an action");
        MDC.remove("userId");
    }
}
