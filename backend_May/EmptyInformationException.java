public class EmptyInformationException extends RuntimeException {
    public EmptyInformationException(String message) {
        super(message);
    }

    public EmptyInformationException() {
        super("The information tree is empty. How dare you are!");
    }
}
