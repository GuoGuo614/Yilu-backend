public class PasswordLengthException extends RuntimeException {
    public PasswordLengthException(String message) {
        super(message);
    }

    public PasswordLengthException() {
      super("The length of password should between 6 and 16(exclusive).");
    }
}
