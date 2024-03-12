public class Account {
    private String name;
    Account(String name) throws ContainsNumberException {
        if (name.matches(".*\\d.*")) {
            throw new ContainsNumberException("Name cannot contain numbers");
        }
        this.name = name;
    }
    public void withdraw(int amount) {
        System.out.println("Withdraw " + amount);
    }
    public void deposit(int amount) {
        System.out.println("Deposit " + amount);
    }
}
