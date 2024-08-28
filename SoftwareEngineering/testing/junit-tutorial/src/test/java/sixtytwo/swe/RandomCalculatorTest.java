package sixtytwo.swe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

public class RandomCalculatorTest {

    private Calculator calculator = new Calculator();

    @DisplayName("Simple multiplication should work")
    @RepeatedTest(
            value = 10,
            name = "{displayName} - repetition {currentRepetition} of {totalRepetitions}"
    )
    public void testRandom() {
        Random random = new Random();
        int a = random.nextInt();
        int b = random.nextInt();
        System.out.println(a + " "  + b);
        Assertions.assertEquals(a + b, calculator.add(a, b));
    }
}
