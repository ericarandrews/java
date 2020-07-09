import java.util.Arrays;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class EmployeeGUIView {
	
	private TextField idField, nameField;
	private ComboBox<Status> statusComboBox;
	private Text introText, idLabel, nameLabel, statusLabel, resultLabel;
	private TextArea result;
	private Button addButton, displayButton, benefitsButton;
	private VBox primaryBox;
	
	private final static Status DEFAULT_STATUS = Status.ACTIVE;
	private final static Font font = Font.font("Helvetica", 20);
	
	public EmployeeGUIView() {
		System.setProperty("glass.accessible.force", "false");
		
		primaryBox = new VBox();
		primaryBox.setAlignment(Pos.CENTER);
		primaryBox.setSpacing(20);
		primaryBox.setStyle("-fx-background-color: white");

		introText = new Text("Welcome to the Employee input system!\n Provide the employee data below.");
		introText.setFont(font);
		VBox introBox = new VBox(introText);
		introBox.setAlignment(Pos.CENTER);
		introBox.setSpacing(10);
		primaryBox.getChildren().add(introBox);
		
		nameLabel = new Text("Enter the name:");
		nameLabel.setFont(font);
		nameField = new TextField();
		VBox nameBox = new VBox(nameLabel, nameField);
		nameBox.setAlignment(Pos.CENTER);
		nameBox.setSpacing(10);
		primaryBox.getChildren().add(nameBox);
		
		idLabel = new Text("Enter the ID:");
		idLabel.setFont(font);
		idField = new TextField();
		VBox idBox = new VBox(idLabel, idField);
		idBox.setAlignment(Pos.CENTER);
		idBox.setSpacing(10);
		primaryBox.getChildren().add(idBox);
		
		statusLabel = new Text("Select the status:");
		statusLabel.setFont(font);
		ObservableList<Status> statusOptions = FXCollections.observableArrayList((Arrays.asList(Status.values())));
		// Status.values() returns Status[] with three objects {Status.ACTIVE, Status.INACTIVE_TEMP, Status.INACTIVE_PERM}
		// Arrays.asList converts the array to a List
		// FXCollections.observableArrayList converts to an ObservableList, which can be pased to the ComboBox constructor
		statusComboBox = new ComboBox<Status>(statusOptions);
		statusComboBox.setValue(Status.ACTIVE);
		VBox statusBox = new VBox(statusLabel, statusComboBox);
		statusBox.setAlignment(Pos.CENTER);
		statusBox.setSpacing(10);
		primaryBox.getChildren().add(statusBox);
		
		addButton = new Button("Add Employee");
		displayButton = new Button("Show Employee Data");
		benefitsButton = new Button("Process Benefits");
		
		HBox buttonBox = new HBox(addButton, displayButton, benefitsButton);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(10);
		primaryBox.getChildren().add(buttonBox);

		resultLabel = new Text("");
		resultLabel.setFont(font);
		resultLabel.setFill(Color.BLUE);
		resultLabel.setVisible(false);
		result = new TextArea("");
		result.setVisible(false);
		result.setEditable(false);
		VBox resultBox = new VBox(resultLabel, result);
		resultBox.setAlignment(Pos.CENTER);
		resultBox.setSpacing(10);
		primaryBox.getChildren().add(resultBox);

	}
	
	public Parent getParent() {
		return primaryBox;
	}

	public void setProcessBenefitsAction(EventHandler<ActionEvent> handler) {
		benefitsButton.setOnAction(handler);
	}
	public void setDisplayEmployeesAction(EventHandler<ActionEvent> handler) {
		displayButton.setOnAction(handler);
	}
	public void setAddEmployeeAction(EventHandler<ActionEvent> handler) {
		addButton.setOnAction(handler);
	}

	public void displayResultText(String label, String output) {
		resultLabel.setVisible(true);
		resultLabel.setText(label);
		
		result.clear();
		result.setVisible(true);
		result.setText(output);
	}
	
	public void hideResultText() {
		result.clear();
		result.setVisible(false);
		resultLabel.setVisible(false);
	}
	public void clearInputs() {
		nameField.clear();
		idField.clear();
		statusComboBox.setValue(DEFAULT_STATUS);
	}
	
	public String getNameField() {
		return nameField.getText();
	}
	public String getIdField() {
		return idField.getText();
	}
	public Status getStatusField() {
		return statusComboBox.getValue();
	}
	
	public void setNameField(String text) {
		nameField.setText(text);
	}
	public void setIdField(String text) {
		idField.setText(text);
	}
	
	public void setStatusField(Status status) {
		statusComboBox.setValue(status);
	}
	
	
	
	

	
}
