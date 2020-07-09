import java.util.Scanner;

public class AccountConsoleView {

    private String username;
    private Scanner scan;

    public AccountConsoleView() {
        scan = new Scanner(System.in);
    }

    public String getUsername() {
        System.out.println("Enter the username:");
        username = scan.nextLine();
        return username;
    }

    public void displayUsername(String text) {
        System.out.println("Username: " + text);
    }

    public void displayAccountData(String username, String password) {
        System.out.println("Username: " + username + "\n" + "Password: " + password);
    }

}
