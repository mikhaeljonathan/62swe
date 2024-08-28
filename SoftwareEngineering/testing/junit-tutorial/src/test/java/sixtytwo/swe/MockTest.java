package sixtytwo.swe;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {

    @Test
    void testMock() {
        List<String> list = Mockito.mock(List.class);

        Mockito.when(list.get(100)).thenReturn("world");
        Mockito.when(list.size()).thenReturn(1);

        System.out.println(list.get(100));
        System.out.println(list.get(100));
        System.out.println(list.size());

        Mockito.verify(list, Mockito.times(2)).get(100);
    }
}
