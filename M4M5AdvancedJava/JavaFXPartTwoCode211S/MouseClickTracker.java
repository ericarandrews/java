import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class MouseClickTracker extends Application {

	private Pane pane;
	private BorderPane borderPane;
	private final static int CIRCLE_RADIUS = 10;
	private int clickCount;
	private Text clickCountText;
	
	public void start(Stage primaryStage) {
		borderPane = new BorderPane();
		clickCount = 0;
		
		pane = new Pane();
		pane.setOnMouseClicked(this::handleMouseClicks);
		borderPane.setCenter(pane);
		
		clickCountText = new Text("Click Count: 0");
		clickCountText.setFont(Font.font("Times", FontWeight.BOLD, 28));
		HBox textBox = new HBox(clickCountText);
		textBox.setAlignment(Pos.CENTER);
		borderPane.setBottom(textBox);
		
		Scene scene = new Scene(borderPane, 500, 500, Color.TURQUOISE);
		primaryStage.setTitle("Tracking Mouse Clicks");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void handleMouseClicks(MouseEvent event) {
		clickCount++;
		clickCountText.setText("Click Count: " + clickCount);
		
		double x = event.getX();
		double y = event.getY();
		
		Circle circle = new Circle(x, y, CIRCLE_RADIUS);
		String coordinateString = "(" + x + ", " + y + ")";
		Text coordinates = new Text(x-CIRCLE_RADIUS, y-CIRCLE_RADIUS-2, coordinateString);
		pane.getChildren().add(circle);
		pane.getChildren().add(coordinates);
		
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
