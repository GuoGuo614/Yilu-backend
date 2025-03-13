package topic_2;

public class Account {
    public static void main(String[] args) throws InsufficientBalanceException {
        Account Guo = new Account("2024090903014", 10);
        try {
            Guo.withdraw(20);
        } catch (InsufficientBalanceException e) {
            System.err.println(e.getMessage());
        }
    }

    public Account(String aNumber, double aBalance) {
        number = aNumber;
        balance = aBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException(number, balance);
        }
        balance -= amount;
    }

    private String number;
    private double balance;
}
