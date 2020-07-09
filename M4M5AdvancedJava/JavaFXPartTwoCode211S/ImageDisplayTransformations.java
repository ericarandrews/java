import javafx.application.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class ImageDisplayTransformations extends Application {
	
	public void start(Stage primaryStage) {
		
		/* Translation */
		int startX = 100, startY = 100, length = 200, width = 50;
		
		Group group = new Group();
		for(int i=0; i<10; i++) {
			Rectangle rect = new Rectangle(startX, startY, length, width);
			rect.setTranslateX(i*10);
			rect.setTranslateY(i*10);
			rect.setFill(Color.TRANSPARENT);
			rect.setStroke(Color.BLACK);
			group.getChildren().add(rect);
		}
	
		/*
		Rectangle r1 = new Rectangle(0,0,100,100);
		r1.setStroke(Color.RED);
		r1.setFill(Color.RED);
		group.getChildren().add(r1);
		System.out.println(r1);
		r1.setTranslateX(50);
		System.out.println(r1);
		System.out.println(r1.getTranslateX());
		*/
		
		/* Scaling */	
		Image dogImage = new Image("dogs.jpg", 200, 200, true, true);
		ImageView dogImageView = new ImageView(dogImage);
		
		ImageView smallDogImageView = new ImageView(dogImage);
		smallDogImageView.setScaleX(.5);
		smallDogImageView.setScaleY(.5);
		
		HBox imageBox = new HBox(dogImageView, smallDogImageView);
		group.getChildren().add(imageBox);
		
		
		/* Rotation */	
		ImageView rotatedDogImageView = new ImageView(dogImage);
		rotatedDogImageView.setRotate(90);
		imageBox.getChildren().add(rotatedDogImageView);
		

		
		//Pane pane = new FlowPane(group);
		Scene scene = new Scene(group, 400, 400);		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Transformations!");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);

	}
	

}
