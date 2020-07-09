import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;


public class MouseTail extends Application {

	private final static int TAIL_SIZE = 3;
	private Pane pane;
	
	public void start(Stage primaryStage) {
		pane = new Pane();
		pane.setOnMouseMoved(this::handleMouseMotion);
		
		Scene scene = new Scene(pane, 500, 500, Color.KHAKI);
		primaryStage.setTitle("Mouse Tail");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void handleMouseMotion(MouseEvent event) {
		double x = event.getX();
		double y = event.getY();
		
		Circle circle = new Circle(x, y, 5);
		if(pane.getChildren().size() > TAIL_SIZE) {
			pane.getChildren().remove(0);
			pane.getChildren().add(circle);
		} else {
			pane.getChildren().add(circle);
		}
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
