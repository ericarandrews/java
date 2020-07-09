import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class GUIImageDisplay extends Application {
	
	public void start(Stage primaryStage) {
		
		VBox primaryBox = new VBox();
		primaryBox.setAlignment(Pos.CENTER);
		primaryBox.setSpacing(70);
		
		Image dogImage = new Image("dogs.jpg", 300, 300, true, true);
		ImageView dogImageView = new ImageView(dogImage);
		dogImageView.setRotate(90);
		primaryBox.getChildren().add(dogImageView);
		
		Text dogDescription = new Text("Tessie and Bacchus");
		dogDescription.setFont(Font.font(20));
		primaryBox.getChildren().add(dogDescription);
	
		
		Scene scene = new Scene(primaryBox, 400, 400, Color.BEIGE);
		primaryStage.setTitle("GUI Image");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
