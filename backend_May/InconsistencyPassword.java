public class InconsistencyPassword extends RuntimeException {
    public InconsistencyPassword(String message) {
        super(message);
    }

    public InconsistencyPassword() {
        super("The two entered passwords do not match.");
    }
}
