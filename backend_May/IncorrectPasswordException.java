public class IncorrectPasswordException extends RuntimeException {
  public IncorrectPasswordException(String message) {
    super(message);
  }

  public IncorrectPasswordException() {
    super("Password Error!!!");
  }
}
