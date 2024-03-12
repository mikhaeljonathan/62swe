import java.util.List;

public class Generic<T> {
    public void add(List<? super Car> asdf) {
        System.out.println(asdf);
    }
}
