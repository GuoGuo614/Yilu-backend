import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        if (Repository.USERS_STORE.exists()) {
            Repository.userInformation = Utils.readObject(Repository.USERS_STORE, TreeMap.class);
        } else {
            Repository.userInformation = new TreeMap<>();
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Repository.displayMenu();
            int x = scanner.nextInt();
            switch (x) {
                case 1:
                    try {
                        Repository.login();
                    } catch (InvalidStringException | AccountNonExistentException |
                             IncorrectPasswordException | EmptyInformationException e) {
                        System.err.println("Login failed: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Repository.register();
                    } catch (AccountAlreadyExistsException | InconsistencyPassword | GenderException |
                             InvalidAccountFormatException | PasswordLengthException e) {
                        System.err.println("Registration failed: " + e.getMessage());
                    }
                    break;
                case 3:
                    Utils.writeObject(Repository.USERS_STORE, Repository.userInformation);
                    System.out.println("You have already exited the system. Users saved.");
                    System.exit(0);
                case 4:
                    try {
                        Repository.logout();
                    } catch (InvalidStringException | AccountNonExistentException |
                             IncorrectPasswordException | EmptyInformationException e) {
                        System.err.println("Logout failed: " + e.getMessage());
                    }
                    break;
                default:
                    System.err.println("Invalid option number, please enter again.");
            }
        }
    }
}
