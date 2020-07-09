import java.util.Optional;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.stage.Stage;

public class DialogBoxExample extends Application {

	public void start(Stage primaryStage) {

		boolean keepGoing = true;

		while (keepGoing) {
			TextInputDialog inputDialog = new TextInputDialog();
			inputDialog.setHeaderText(null);
			inputDialog.setTitle("Number Dialog");
			inputDialog.setContentText("Enter a number: ");

			Optional<String> userInput1 = inputDialog.showAndWait();
			if (userInput1.isPresent()) {
				String userInputString = userInput1.get();
				int userNumber1 = Integer.parseInt(userInputString);

				inputDialog.getEditor().clear();
				Optional<String> userInput2 = inputDialog.showAndWait();

				if (userInput2.isPresent()) {
					String userInputString2 = userInput2.get();
					int userNumber2 = Integer.parseInt(userInputString2);

					int sum = userNumber1 + userNumber2;
					int product = userNumber1 * userNumber2;

					Alert resultAlert = new Alert(AlertType.INFORMATION);
					resultAlert.setTitle("Results");
					resultAlert.setHeaderText(null);
					resultAlert.setContentText("Sum = " + sum + " and Product = " + product);
					resultAlert.showAndWait();

					Alert againAlert = new Alert(AlertType.CONFIRMATION);
					againAlert.setTitle("Again?");
					againAlert.setHeaderText(null);
					againAlert.setContentText("Enter another pair?");
					Optional<ButtonType> userSelection = againAlert.showAndWait();

					if (userSelection.isPresent() && userSelection.get() == ButtonType.OK) {
						keepGoing = true;
					} else {
						keepGoing = false;
					}

				}

			} else {
				System.out.println("No user input");
				keepGoing = false;
			}

		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}
