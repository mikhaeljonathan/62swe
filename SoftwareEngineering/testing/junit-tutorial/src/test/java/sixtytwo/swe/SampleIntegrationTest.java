package sixtytwo.swe;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

// mvn test -Dgroups=tag1,tag2
@Tags({
        @Tag("integration-test")
})
public class SampleIntegrationTest {
    @Test
    void test1() {

    }

    @Test
    void test2() {

    }
}
