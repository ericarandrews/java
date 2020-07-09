import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class SmilyFaceGUI extends Application {
	
	private Button eyeColorButton;
	private Circle faceCircle, leftEye, rightEye, nose;
	private Rectangle mouth;
	private final int EYE_RADIUS = 20;
	private final int LEFT_EYE_CENTER_X = 165;
	private final int RIGHT_EYE_CENTER_X = 325;
	
	public void start(Stage primaryStage) {
		
		faceCircle = new Circle(250, 225, 200);
		faceCircle.setFill(Color.TRANSPARENT);
		faceCircle.setStroke(Color.BLACK);
		
		leftEye = new Circle(LEFT_EYE_CENTER_X, 125, EYE_RADIUS);
		leftEye.setFill(Color.GREEN);
		leftEye.setStroke(Color.BLACK);

		rightEye = new Circle(RIGHT_EYE_CENTER_X, 125, EYE_RADIUS);
		rightEye.setFill(Color.GREEN);
		rightEye.setStroke(Color.BLACK);
		
		nose = new Circle(250, 225, EYE_RADIUS/2);
		nose.setFill(Color.TRANSPARENT);
		nose.setStroke(Color.BLACK);
		
		mouth = new Rectangle(LEFT_EYE_CENTER_X - EYE_RADIUS, 350, (RIGHT_EYE_CENTER_X - LEFT_EYE_CENTER_X + 2 * EYE_RADIUS), 30);
		mouth.setFill(Color.RED);
		
		Group faceShapes = new Group(faceCircle, leftEye, rightEye, nose, mouth);
		
		Text message = new Text(375, 400, "Have a nice day!");
		
		Pane facePane = new Pane(faceShapes, message);
		
		eyeColorButton = new Button("Change Eye Color");
		eyeColorButton.setOnAction(this::handleEyeColorButton);
		
		VBox primaryBox = new VBox();
		primaryBox.setAlignment(Pos.CENTER);
		primaryBox.setSpacing(30);
		primaryBox.getChildren().add(facePane);
		primaryBox.getChildren().add(eyeColorButton);
	//	primaryBox.getChildren().add(message);
		
		Scene scene = new Scene(primaryBox, 500, 500, Color.TRANSPARENT);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void handleEyeColorButton(ActionEvent event) {
		Color eyeColor = Color.color(Math.random(), Math.random(), Math.random());
		leftEye.setFill(eyeColor);
		rightEye.setFill(eyeColor);
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
