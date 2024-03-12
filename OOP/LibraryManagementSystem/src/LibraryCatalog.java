import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog<T extends LibraryItem> {
    private List<T> items;

    LibraryCatalog() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public void printAvailableItems() {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isAvailable) {
                System.out.println(items.get(i).getTitle());
            }
        }
    }
}
