package topic_2;

public class InsufficientBalanceException extends Exception {
    InsufficientBalanceException() {}

    InsufficientBalanceException(String number, double amount) {
        super("Account number: " + number + "; The amount " + amount + " is more than the balance.");
    }
}
