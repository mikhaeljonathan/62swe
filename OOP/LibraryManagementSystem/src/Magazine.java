public class Magazine extends LibraryItem implements Borrowable {
    private String issueNumber;

    Magazine(String title, String author, int year, String issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
    }

    @Override
    public void checkOut() throws ItemNotAvailableException {
        if (!isAvailable) {
            throw new ItemNotAvailableException("Magazine is not available");
        }
        System.out.println("Checking out magazine: " + this.getTitle());
        isAvailable = false;
    }

    @Override
    public void borrowItem() {
        System.out.println("Borrowing magazine: " + this.getTitle());
    }

    @Override
    public boolean returnItem() {
        System.out.println("Returning magazine: " + this.getTitle());
        return true;
    }
}
