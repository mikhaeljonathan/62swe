public class Book extends LibraryItem implements Borrowable{
    private String bookGenre;

    Book(String title, String author, int year, String bookGenre) {
        super(title, author, year);
        this.bookGenre = bookGenre;
    }

    @Override
    public void checkOut() throws ItemNotAvailableException {
        if (!isAvailable) {
            throw new ItemNotAvailableException("Book is not available");
        }
        System.out.println("Checking out book: " + this.getTitle());
        isAvailable = false;
    }

    @Override
    public void borrowItem() {
        System.out.println("Borrowing book: " + this.getTitle());
    }

    @Override
    public boolean returnItem() {
        System.out.println("Returning book: " + this.getTitle());
        return true;
    }
}
