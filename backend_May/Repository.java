import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

public class Repository {
    public static TreeMap<String, User> userInformation;
    private static final Scanner scanner = new Scanner(System.in);
    public static final File CWD = new File(System.getProperty("user.dir"));
    public static final File USERS_STORE = Utils.join(Repository.CWD, "userInformation");

    // 服务大厅界面打印
    public static void displayMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("  +++ Steins Gate Initiative: Anti-SERN Login +++ ");
        System.out.println("--------------------------------------------------");
        System.out.println("El Psy Kongroo.");
        System.out.println();
        System.out.println("Welcome to the Service Hall of Anti-SERN Committee.");
        System.out.println("To proceed, please select an option:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Save and Exit");
        System.out.println("4. Logout");
    }

    // 登录函数
    public static void login() throws InvalidStringException, AccountNonExistentException, IncorrectPasswordException, EmptyInformationException {
        if (userInformation.isEmpty()) {
            throw new EmptyInformationException();
        }

        String account = getValidString("account");
        if (!userInformation.containsKey(account)) {
            throw new AccountNonExistentException();
        }
        User user = userInformation.get(account);

        String password = getValidString("password");
        if (!user.getPassword().equals(password)) {
            throw new IncorrectPasswordException();
        }

        user.printUser();
    }

    // 注册函数
    public static void register() throws AccountAlreadyExistsException, InconsistencyPassword, GenderException {
        String account = getValidString("account");
        if (userInformation.containsKey(account)) {
            throw new AccountAlreadyExistsException();
        } else if (!account.matches("^[a-zA-Z0-9]+$")) {
            throw new InvalidAccountFormatException();
        }

        String password = getValidString("password");
        String passwordCheck = getValidString("confirm password");
        if (!passwordCheck.equals(password)) {
            throw new InconsistencyPassword();
        } else if (password.length() < 6 || password.length() > 16) {
            throw new PasswordLengthException();
        }

        String gender = getValidString("gender (male or female)");
        if (!gender.equals("male") && !gender.equals("female")) {
            throw new GenderException();
        }

        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        userInformation.put(account, new User(account, password, name, gender));
        System.out.println("Account " + account + " has been successfully registered.");
    }

    // 注销函数
    public static void logout() throws InvalidStringException, AccountNonExistentException, IncorrectPasswordException, EmptyInformationException {
        if (userInformation.isEmpty()) {
            throw new EmptyInformationException();
        }

        String account = getValidString("account for logout");
        if (!userInformation.containsKey(account)) {
            throw new AccountNonExistentException();
        }
        User user = userInformation.get(account);

        String password = getValidString("password for logout");
        if (!user.getPassword().equals(password)) {
            throw new IncorrectPasswordException();
        }

        userInformation.remove(account);
        System.out.println("Account " + account + " has been successfully logged out and removed.");
    }

    // 请求用户输入特定类型字符串，并判断是否无空格
    private static String getValidString(String kind) throws InvalidStringException {
        System.out.print("Please enter your " + kind + ": ");
        String result = scanner.nextLine();
        assertValidString(result);
        return result;
    }

    private static void assertValidString(String s) throws InvalidStringException {
        if (s.isEmpty() || s.contains(" ")) {
            throw new InvalidStringException();
        }
    }

    public static Scanner getScanner() {
        return scanner;
    }
}
