package sixtytwo.swe;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// CAN BE ALPHANUMERIC OR RANDOM OR METHODNAME
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {

    @Test
    @Order(3)
    void test1() {

    }

    @Test
    @Order(1)
    void test2() {

    }

    @Test
    @Order(2)
    void test3() {

    }
}
