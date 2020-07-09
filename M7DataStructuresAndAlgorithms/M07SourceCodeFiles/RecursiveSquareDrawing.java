import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.*;


public class RecursiveSquareDrawing  extends Application  {



	private final int INITIAL_SIZE = 200; 		
	private final int INITIAL_X = 125, INITIAL_Y = 125;
	private final int MINIMUM_SIZE = 50;	// minimum size of smallest square to draw
	private final int SIZE_FACTOR = 2; 		// factor to "shrink" the square each time
	private final static int WIDTH = 500, HEIGHT = 500;
	private Pane squaresPane;

	private Group shapeGroup;
	
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		
		

		shapeGroup = new Group();
		createRectangle(INITIAL_X, INITIAL_Y, INITIAL_SIZE);
		squaresPane = new Pane(shapeGroup);
		
		borderPane.setCenter(squaresPane);
		
		Scene scene = new Scene(borderPane, WIDTH, HEIGHT, Color.TRANSPARENT);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Recursive Rectangles!");
		primaryStage.show();
	}

	
	private void createRectangle(int x, int y, int size) {

			  if(size >= MINIMUM_SIZE) {
				  Rectangle rec = new Rectangle(x, y, size, size);
				  rec.setFill(Color.GRAY);
				  rec.setStroke(Color.BLACK);
				  shapeGroup.getChildren().add(rec);
				  

	 	       	// recursively draw 4 smaller squares- one on each corner
				  createRectangle( (x - (size/SIZE_FACTOR)/2),  (y -(size/SIZE_FACTOR)/2), size/SIZE_FACTOR);    // upper left  
				  createRectangle( (x + size -(size/SIZE_FACTOR)/2),  (y - (size/SIZE_FACTOR)/2), size/SIZE_FACTOR);    // upper right   
				  createRectangle( (x - (size/SIZE_FACTOR)/2),  (y + size -(size/SIZE_FACTOR)/2), size/SIZE_FACTOR);    // lower left 
				  createRectangle( (x + size - (size/SIZE_FACTOR)/2),  (y + size - (size/SIZE_FACTOR)/2), size/SIZE_FACTOR);    // lower right
			}
	}
	

	
	public static void main(String[] args) {
		launch(args);

	}

}
