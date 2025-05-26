public class AccountNonExistentException extends RuntimeException {
    public AccountNonExistentException(String message) {
        super(message);
    }

    public AccountNonExistentException() {
        super("Your haven't register by this account yet.");
    }
}
