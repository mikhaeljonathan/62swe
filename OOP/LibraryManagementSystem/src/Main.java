public class Main {
    public static void main(String[] args) {
        LibraryCatalog<Book> bookCatalog = new LibraryCatalog<>();
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 1937, "Fantasy");
        bookCatalog.addItem(book);
        bookCatalog.addItem(new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954, "Fantasy"));
        bookCatalog.addItem(new Book("The Two Towers", "J.R.R. Tolkien", 1954, "Fantasy"));

        LibraryCatalog<Magazine> magazineCatalog = new LibraryCatalog<>();
        Magazine magazine = new Magazine("National Geographic", "National Geographic Society", 1888, "January 2021");
        magazineCatalog.addItem(magazine);
        magazineCatalog.addItem(new Magazine("Time", "Time Inc.", 1923, "January 2021"));
        magazineCatalog.addItem(new Magazine("Forbes", "Integrated Whale Media", 1917, "January 2021"));

        bookCatalog.printAvailableItems();
        magazineCatalog.printAvailableItems();

        try {
            book.checkOut();
        } catch (ItemNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}