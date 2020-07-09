import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EmployeeGUIController extends Application {

	private Department department;
	private EmployeeGUIView employeeInputView;

	public EmployeeGUIController() {
		department = new Department(); // the model
		employeeInputView = new EmployeeGUIView(); // the view
		
		employeeInputView.setProcessBenefitsAction(this::processBenefits);
		employeeInputView.setDisplayEmployeesAction(this::displayEmployees);
		employeeInputView.setAddEmployeeAction(this::addEmployee);
	}

	@Override
	public void start(Stage primaryStage) {
		EmployeeGUIController controller = new EmployeeGUIController();

		Scene scene = new Scene(controller.employeeInputView.getParent(), 450, 500, Color.TRANSPARENT);
		primaryStage.setTitle("Employee Data Processing System");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void addEmployee(ActionEvent event) {
		String errorMessage = "";
		try {
			String name = employeeInputView.getNameField(); // getting info from view
			if (name.isEmpty()) {
				errorMessage = "Name must not be empty.";
				throw new IllegalArgumentException();
			}

			try {
				String idText = employeeInputView.getIdField(); // getting info from view

				if (idText.isEmpty()) {
					errorMessage = "ID must not be empty.";
					throw new IllegalArgumentException();
				}
				int id = Integer.parseInt(idText);

				Status status = employeeInputView.getStatusField(); // getting info from view

				Employee employee = new FullTimeEmployee(id, name, status); // send info to the model for processing
				department.addEmployee(employee);
			} catch (NumberFormatException ex) {
				errorMessage = "ID must be numeric.";
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException ex) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Error");
			error.setHeaderText(null);
			error.setContentText(errorMessage);
			error.showAndWait();

		} finally {
			employeeInputView.clearInputs(); // update the view- we clear it out for new input
			employeeInputView.hideResultText();
		}

	}

	private void processBenefits(ActionEvent event) {
		ArrayList<Employee> empList = department.getEmployeeList(); // tell the model to process and get results from the model
		String output = "";
		for (Employee e : empList) {
			output += e.benefits() + "\n";
		}
		employeeInputView.displayResultText("Processing Benefits", output); // send results back to the view
	}

	private void displayEmployees(ActionEvent event) {
		ArrayList<Employee> empList = department.getEmployeeList(); // tell the model to process and get the results from the mode
		String output = "";
		for (Employee e : empList) {
			output += e.toString() + "\n";
		}
		employeeInputView.displayResultText("Employees:", output); // send results back to the view

	}

}
