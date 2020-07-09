import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class AccountGUIView   {

	private TextField usernameField;
	private Text usernameLabel, loginInfoText;
	private Button generatePasswordButton;
	private VBox primaryBox;
	
	private final static Font font = Font.font("Helvetica", 20);
	
	public AccountGUIView() {
		primaryBox = new VBox();
		primaryBox.setAlignment(Pos.CENTER);
		primaryBox.setSpacing(20);
		primaryBox.setStyle("-fx-background-color: white");
		
		usernameLabel = new Text("Enter your username: ");
		usernameLabel.setFont(font);
		usernameField = new TextField();
		VBox usernameBox = new VBox(usernameLabel, usernameField);
		usernameBox.setAlignment(Pos.CENTER);
		usernameBox.setSpacing(10);
		primaryBox.getChildren().add(usernameBox);
		
		generatePasswordButton = new Button("Generate Password");
		HBox buttonBox = new HBox(generatePasswordButton);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(10);
		primaryBox.getChildren().add(buttonBox);
		
		loginInfoText = new Text();
		loginInfoText.setFont(font);
		VBox passwordBox = new VBox(loginInfoText);
		passwordBox.setAlignment(Pos.CENTER);
		passwordBox.setSpacing(10);
		primaryBox.getChildren().add(passwordBox);
		
	}
	public Parent getParent() {
		return primaryBox;
	}

	public String getUsername() {
		return usernameField.getText();
	}
	public void displayUsername(String text) {
		usernameField.setText(text);
	}
	public void disableUsernameInput() {
		usernameField.setEditable(false);
	}
	public void displayAccountData(String username, String password) {
		loginInfoText.setText("Username: " + username + "\n" + "Password: " + password);
	}
	
	public void setOnAction(EventHandler<ActionEvent> handler) {
		generatePasswordButton.setOnAction(handler);
	}

}
