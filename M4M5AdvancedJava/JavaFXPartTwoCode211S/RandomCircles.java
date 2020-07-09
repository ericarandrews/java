import java.util.Optional;
import java.util.Random;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class RandomCircles extends Application {
	
	private final static int WIDTH = 500, HEIGHT = 500;
	private final static int DEFAULT_NUM_CIRCLES = 50;
	private Button redrawButton;
	private Pane circlesPane;
	private CheckBox fillCheckBox;
	private RadioButton bwRadioButton, randomColorRadioButton;
	private int numCircles;
	
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		
		numCircles = getUserNumCircles();
		//System.out.println("got to here");
		
		redrawButton = new Button("Redraw Circles");
		redrawButton.setOnAction(this::handleButtons);
		
		fillCheckBox = new CheckBox("Filled?");
		fillCheckBox.setOnAction(this::handleButtons);
		
		ToggleGroup colorGroup = new ToggleGroup();
		bwRadioButton = new RadioButton("B&W");
		bwRadioButton.setSelected(true);
		bwRadioButton.setToggleGroup(colorGroup);
		bwRadioButton.setOnAction(this::handleButtons);
		randomColorRadioButton = new RadioButton("Random Colors");
		randomColorRadioButton.setToggleGroup(colorGroup);
		randomColorRadioButton.setOnAction(this::handleButtons);
		
		HBox controlBox = new HBox(redrawButton, fillCheckBox, bwRadioButton, randomColorRadioButton);
		controlBox.setAlignment(Pos.CENTER);
		controlBox.setPadding(new Insets(10, 10, 10, 10));
		controlBox.setSpacing(10);
		
		borderPane.setBottom(controlBox);
		
		circlesPane = new Pane();
		circlesPane.getChildren().add(createCircles());
		
		borderPane.setCenter(circlesPane);
		
		Scene scene = new Scene(borderPane, WIDTH, HEIGHT, Color.TRANSPARENT);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Circles!");
		primaryStage.show();
	}

	private int getUserNumCircles() {
		TextInputDialog inputDialog = new TextInputDialog();
		inputDialog.setHeaderText(null);
		inputDialog.setTitle(null);
		inputDialog.setContentText("How many circles?");
		
		Optional<String> userInput = inputDialog.showAndWait();
		String errorMessage = "";
		if(userInput.isPresent()) {
			String userInputString = userInput.get();
			try {
				numCircles = Integer.parseInt(userInputString);
				return numCircles;
			} catch(NumberFormatException ex) {
				errorMessage = "Error! That is not a number! Drawing " + DEFAULT_NUM_CIRCLES + " circles.";
			}

		} else {
			errorMessage = "Error! No number entered. Drawing " + DEFAULT_NUM_CIRCLES + " circles.";
		}
		
		Alert error = new Alert(AlertType.ERROR);
		error.setHeaderText(null);
		error.setTitle("Error!");
		error.setContentText(errorMessage);
		error.showAndWait();
		return DEFAULT_NUM_CIRCLES;
		

	}
	
	private void handleButtons(ActionEvent event) {
		circlesPane.getChildren().remove(0);
		circlesPane.getChildren().add(createCircles());
	}
	
	private Group createCircles() {
		Group circleGroup = new Group();
		
		Random generator = new Random();
		for(int i=0; i<numCircles; i++) {
			int x = generator.nextInt(WIDTH);
			int y = generator.nextInt((int) (HEIGHT*.8));
			int radius = generator.nextInt(WIDTH/6);
			
			Circle circle = new Circle(x, y, radius);
			
			Color currentColor;
			if(bwRadioButton.isSelected()) {
				currentColor = Color.BLACK;
			} else { // randomColorRadioButton.isSelected()
				currentColor = Color.color(Math.random(), Math.random(), Math.random());
			}
			
			if(fillCheckBox.isSelected()) {
				circle.setFill(currentColor);
			} else {
				circle.setFill(Color.TRANSPARENT);
			}
			circle.setStroke(currentColor);
			circleGroup.getChildren().add(circle);
		}
		return circleGroup;
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
