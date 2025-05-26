public class InvalidAccountFormatException extends RuntimeException {
    public InvalidAccountFormatException(String message) {
        super(message);
    }

    public InvalidAccountFormatException() {
        super("The account can only contain lowercase, uppercase and digits.");
    }
}
