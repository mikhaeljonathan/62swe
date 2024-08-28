package sixtytwo.swe;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) //PER_METHOD is the default
public class PerClassTest {

    private int counter = 0;

    // beforeAll and afterAll doesn't have to be static
    @BeforeAll
    void beforeAll() {

    }

    @AfterAll
    void afterAll() {

    }

    @Test
    void test1() {
        counter++;
        System.out.println(counter);
    }

    @Test
    void test2() {
        counter++;
        System.out.println(counter);
    }

    @Test
    void test3() {
        counter++;
        System.out.println(counter);
    }
}


