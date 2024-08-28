package sixtytwo.swe;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

// demo for nested test

@DisplayName("A queue")
public class QueueTest {
    private Queue<String> queue;

    @Nested
    @DisplayName("when new")
    public class WhenNew {

        @BeforeEach
        void setUp() {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("When offer once, size must be 1")
        void offerNewData() {
            queue.offer("test1");
            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("When offer two times, size must be 2")
        void offerMoreData() {
            queue.offer("test1");
            queue.offer("test2");
            Assertions.assertEquals(2, queue.size());
        }
    }

    @Nested
    @DisplayName("when exist")
    public class WhenExists {
        // TODO
    }
}
