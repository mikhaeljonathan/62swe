package sixtytwo.swe;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

public class ConditionTest {

    @Test
    @EnabledOnOs({OS.MAC})
    public void testRunOnlyOnMac() {
        System.out.println("This test will run only on Mac OS");
    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnlyOnWindows() {
        System.out.println("This test will run only on Windows OS");
    }

    @Test
    @DisabledOnOs({OS.MAC})
    public void testDisableOnMac() {
        System.out.println("This test will not run on Mac OS");
    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisableOnWindows() {
        System.out.println("This test will not run on Windows OS");
    }

    @Test
    @EnabledOnJre({JRE.JAVA_8})
    public void testRunOnlyOnJava8() {
        System.out.println("This test will run only on Java 8");
    }

    @Test
    @DisabledOnJre({JRE.JAVA_8})
    public void testDisableOnJava8() {
        System.out.println("This test will not run on Java 8");
    }

    @Test
    @EnabledOnJre({JRE.JAVA_11})
    public void testRunOnlyOnJava11() {
        System.out.println("This test will run only on Java 11");
    }

    @Test
    @DisabledOnJre({JRE.JAVA_11})
    public void testDisableOnJava11() {
        System.out.println("This test will not run on Java 11");
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11)
    public void testRunOnlyOnJava8To11() {
        System.out.println("This test will run only on Java 8 to 11");
    }

    @Test
    void testSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    @Test
    @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void testRunOnlyOnOracleJDK() {
        System.out.println("This test will run only on Oracle JDK");
    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation"),
            @EnabledIfSystemProperty(named = "java.version", matches = "1.8")
    })
    public void testRunOnlyOnOracleJDKAndJava8() {
        System.out.println("This test will run only on Oracle JDK and Java 8");
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testRunOnlyOnDevEnvironment() {
        System.out.println("This test will run only on DEV environment");
    }

}
