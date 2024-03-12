public class Bank {
    public void transferMoney(Account from, Account to, int amount) throws NegativeAmountException{
        if(amount < 0){
            throw new NegativeAmountException("Amount cannot be negative");
        }
        from.withdraw(amount);
        to.deposit(amount);
    }
}
