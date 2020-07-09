import java.util.*;

public class AccountConsoleController {

	private Account accountModel;
	private AccountConsoleView accountView;

	public AccountConsoleController() {
		accountView = new AccountConsoleView();
	}
	
	private void start() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Click 1 to run the program or any other key to exit.");
		while (Integer.parseInt(scan.nextLine()) == 1) {
			runConsoleInteraction();
			System.out.println("Click 1 to run the program or any other key to exit.");
		}
	}

	private void runConsoleInteraction() {
		
	    String username;
		if (accountModel == null) {
		     username = accountView.getUsername(); // get info from the view
			accountModel = new Account(username); // passing info to the model for processing
		} else {
		    username = accountModel.getUsername();
			accountModel.generatePassword(); 
		}
		String password = accountModel.getPassword(); // getting results from the model
 
		accountView.displayAccountData(username, password); // giving results to the view to display to the user

	}

	public static void main(String[] args) {
		AccountConsoleController controller = new AccountConsoleController();
		controller.start();
	}

}
