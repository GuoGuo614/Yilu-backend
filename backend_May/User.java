import java.io.Serializable;

public class User implements Serializable {
    private String account;
    private String password;
    private String name;
    private String gender;

    public User(String anAccount, String aPassword, String aName, String aSex) {
        account = anAccount;
        password = aPassword;
        name = aName;
        gender = aSex;
    }

    public String getPassword() {
        return password;
    }

    // 用户信息一键打印
    public void printUser() {
        System.out.println("Here is the information about this user: ");
        System.out.println("Account: " + account);
        System.out.println("Name of user: " + name);
        System.out.println("Gender of user: " + gender);
    }
}
