public abstract class LibraryItem {
    private String title;
    private String author;
    private int year;
    private ItemDetails itemDetails = new ItemDetails();
    protected boolean isAvailable = true;

    private static int totalItems = 0;

    class ItemDetails {
        private String publisher;
        private String ISBN;
    }

    LibraryItem() {
        totalItems++;
    }


    LibraryItem(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        totalItems++;
    }

    public static int getTotalItems() {
        return totalItems;
    }

    public abstract void checkOut() throws ItemNotAvailableException;

    public String getTitle() {
        return title;
    }

    public void setItemDetails(String publisher, String ISBN) {
        itemDetails.publisher = publisher;
        itemDetails.ISBN = ISBN;
    }

}
