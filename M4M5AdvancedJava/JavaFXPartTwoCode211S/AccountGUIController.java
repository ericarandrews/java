import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccountGUIController extends Application {
	
	private Account accountModel;
	private AccountGUIView accountView;
	
	public AccountGUIController() {	
		accountView = new AccountGUIView();
		accountView.setOnAction(this::processPasswordButton);	
	}

	private void processPasswordButton(ActionEvent event) {
		String username = accountView.getUsername(); // get info from the view
		
		if(accountModel==null) { // send info to the model for processing
			accountModel = new Account(username);
			accountView.disableUsernameInput();
		} else {
			accountModel.generatePassword();
		}
		
		String password = accountModel.getPassword(); // get the results back from the model
	
		accountView.displayAccountData(username, password); // send the results back to the view to display to the user
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		AccountGUIController controller = new AccountGUIController();

		Scene scene = new Scene(controller.accountView.getParent(), 400, 400);
		primaryStage.setTitle("Account Username and Password");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
