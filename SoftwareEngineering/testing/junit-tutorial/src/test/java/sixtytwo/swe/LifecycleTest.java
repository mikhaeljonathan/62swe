package sixtytwo.swe;

import org.junit.jupiter.api.Test;

public class LifecycleTest {

    private String temp;

    /*
    LifecycleTest a = new LifecycleTest();
    a.testA();
     */
    @Test
    void testA() {
        temp = "Indonesia";
    }

    /*
    LifecycleTest b = new LifecycleTest();
    b.testA();
     */
    @Test
    void testB() {
        System.out.println(temp);
    }
}
