package sixtytwo.swe;

import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

@DisplayName("Calculator Test")
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before each");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After each");
    }

    @Test
    @DisplayName("Test Function calculator.add(Integer, Integer)")
    public void testAddSuccess() {
        Assertions.assertEquals(20, calculator.add(10, 10));
    }

    @Test
    public void testDivideSuccess() {
        Assertions.assertEquals(5, calculator.divide(10, 2));
    }

    @Test
    public void testDivideFailure() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }

    @Test
    @Disabled
    public void testComingSoon(){
        // TODO
    }

    // it'll throw an exception in the console, but don't worry because it's expected
    @Test
    public void testAborted(){
        String profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)) {
            throw new TestAbortedException("Test is not running in DEV environment");
        }
        Assertions.assertEquals(10, 20);
    }

    // with assumptions, the TestAbortedException will be thrown automatically
    @Test
    public void testAssumption(){
        Assumptions.assumeTrue("DEV".equals(System.getenv("PROFILE")));
        Assertions.assertEquals(10, 20);
    }
}
