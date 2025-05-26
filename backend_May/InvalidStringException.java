public class InvalidStringException extends RuntimeException {
    public InvalidStringException(String message) {
        super(message);
    }

    public InvalidStringException() {
        super("Your account/password is invalid (empty or has a space).");
    }
}
