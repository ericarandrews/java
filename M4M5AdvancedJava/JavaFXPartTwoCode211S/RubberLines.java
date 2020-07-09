import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class RubberLines extends Application {

	private Line line;
	private boolean lineBeingDrawn;
	
	public void start(Stage primaryStage) {
		lineBeingDrawn = false;
		
		Pane pane = new Pane();
		pane.setOnMouseClicked(this::handleMouseClicks);
		pane.setOnMouseMoved(this::handleMouseMotion);
		
		line = new Line(-10, -10, -10, -10);
		line.setStrokeWidth(5);
		pane.getChildren().add(line);
		
		Scene scene = new Scene(pane, 500, 500, Color.ALICEBLUE);
		primaryStage.setTitle("Rubber Lines");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void handleMouseClicks(MouseEvent event) {
		if(!lineBeingDrawn) { // lineBeingDrawn==false
			lineBeingDrawn = true;
			double x = event.getX();
			double y = event.getY();
			
			line.setStartX(x);
			line.setStartY(y);
			line.setEndX(x);
			line.setEndY(y);
		} else { // lineBeingDrawn==true
			lineBeingDrawn = false;
			
		}
	}
	private void handleMouseMotion(MouseEvent event) {
		if(lineBeingDrawn) {
			double x = event.getX();
			double y = event.getY();
			
			line.setEndX(x);
			line.setEndY(y);
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
