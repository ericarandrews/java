import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class GUIImageDisplayInteractive extends Application {
	
	private CheckBox descriptionDisplayCheckBox;
	private Text animalDescription;
	private RadioButton dogPictureRadioButton, catPictureRadioButton;
	private Image dogImage, catImage;
	private ImageView animalImageView;
	private String dogName, catName;
	
	public void start(Stage primaryStage) {
		
		VBox primaryBox = new VBox();
		primaryBox.setAlignment(Pos.CENTER);
		primaryBox.setSpacing(70);
		
		dogImage = new Image("dogs.jpg", 300, 300, true, true);
		catImage = new Image("cat.jpg", 300, 300, true, true);
		dogName = "Tessie and Bacchus";
		catName = "Zoom";
		
		animalImageView = new ImageView(dogImage);
		animalImageView.setRotate(90);
		primaryBox.getChildren().add(animalImageView);
		
		animalDescription = new Text(dogName);
		animalDescription.setFont(Font.font(20));
		primaryBox.getChildren().add(animalDescription);
		
		descriptionDisplayCheckBox = new CheckBox("Display Description");
		descriptionDisplayCheckBox.setSelected(true);
		descriptionDisplayCheckBox.setOnAction(this::handleDescriptionCheckbox);
		primaryBox.getChildren().add(descriptionDisplayCheckBox);
		
		ToggleGroup pictureGroup = new ToggleGroup();
		dogPictureRadioButton = new RadioButton("Dog Picture");
		dogPictureRadioButton.setToggleGroup(pictureGroup);
		dogPictureRadioButton.setSelected(true);
		dogPictureRadioButton.setOnAction(this::handlePictureRadioButtons);
		
		catPictureRadioButton = new RadioButton("Cat Picture");
		catPictureRadioButton.setToggleGroup(pictureGroup);
		catPictureRadioButton.setOnAction(this::handlePictureRadioButtons);
		
		HBox radioButtonBox = new HBox(dogPictureRadioButton, catPictureRadioButton);
		radioButtonBox.setAlignment(Pos.CENTER);
		radioButtonBox.setSpacing(10);
		primaryBox.getChildren().add(radioButtonBox);
		
		Scene scene = new Scene(primaryBox, 400, 500, Color.BEIGE);
		primaryStage.setTitle("GUI Image");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	private void handlePictureRadioButtons(ActionEvent event) {
		if(dogPictureRadioButton.isSelected()) {
			animalImageView.setImage(dogImage);
			animalImageView.setRotate(90);
			animalDescription.setText(dogName);
			
		} else if(catPictureRadioButton.isSelected()) {
			animalImageView.setImage(catImage);
			animalImageView.setRotate(0);
			animalDescription.setText(catName);
		}
	}
	
	private void handleDescriptionCheckbox(ActionEvent event) {
		if(descriptionDisplayCheckBox.isSelected()) {
			animalDescription.setVisible(true);
		} else if(!descriptionDisplayCheckBox.isSelected()){
			animalDescription.setVisible(false);
		}
	}
	

	public static void main(String[] args) {
		launch(args);

	}

}
