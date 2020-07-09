import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.*;
import javafx.scene.image.*;
import java.util.*;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class ComponentDisplay extends Application {

	private TextArea textArea;
	private Text textAreaLabel, textAreaResults;
	private Button readTextAreaButton;

	private Text sliderLabel, sliderResults;
	private Slider slider;

	private ComboBox<String> stateComboBox;
	private Text stateResult;

	private MenuItem guiItem, dogItem;

	private ListView<String> fruitListView;
	private TextField fruitField;
	private Text fruitSelectedText;
	private Button fruitButton;

	private VBox guiBox, dogBox, primaryBox;

	public void start(Stage primaryStage) {
		System.setProperty("glass.accessible.force", "false");

		primaryBox = new VBox();
		primaryBox.setAlignment(Pos.CENTER);
		primaryBox.setSpacing(20);
		primaryBox.setStyle("-fx-background-color: white");

		// displaying a menu
		MenuBar menuBar = new MenuBar();
		Menu displayMenu = new Menu("Display Choices");
		guiItem = new MenuItem("GUI Component Display");
		guiItem.setOnAction(this::selectMenuItem);
		dogItem = new MenuItem("Puppy Display");
		dogItem.setOnAction(this::selectMenuItem);
		displayMenu.getItems().addAll(guiItem, dogItem);

		menuBar.getMenus().add(displayMenu);
		primaryBox.getChildren().add(menuBar);

		// changing out a major node in the scene graph based on menu selection
		guiBox = createGUIBox();
		primaryBox.getChildren().add(guiBox);
		dogBox = createDogBox();

		// make the view scrollable
		ScrollPane scroller = new ScrollPane(primaryBox);
		scroller.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scroller.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);

		Scene scene = new Scene(scroller, 600, 500);
		primaryStage.setTitle("Component Display");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private VBox createDogBox() {
		VBox localDogBox = new VBox();
		localDogBox.setAlignment(Pos.CENTER);
		localDogBox.setSpacing(20);

		Image dogImage = new Image("puppy.jpg", 400, 400, true, true);
		ImageView dogImageView = new ImageView(dogImage);
		localDogBox.getChildren().add(dogImageView);

		return localDogBox;
	}

	private VBox createGUIBox() {
		VBox localGuiBox = new VBox();
		localGuiBox.setAlignment(Pos.CENTER);
		localGuiBox.setSpacing(20);
		localGuiBox.setPadding(new Insets(10, 10, 20, 10));

		// demonstrate TextArea
		textArea = new TextArea();
		textAreaLabel = new Text("Text Area Chars Entered: ");
		textAreaResults = new Text();
		readTextAreaButton = new Button("Count Text Area Chars");
		readTextAreaButton.setOnAction(event -> {
			String textAreaInput = textArea.getText();
			textAreaResults.setText(Integer.toString(textAreaInput.length()));
		});

		HBox textAreaResultsBox = new HBox(textAreaLabel, textAreaResults);
		textAreaResultsBox.setAlignment(Pos.CENTER);
		textAreaResultsBox.setSpacing(5);

		VBox texetAreaBox = new VBox(textArea, readTextAreaButton, textAreaResultsBox);
		texetAreaBox.setStyle("-fx-border-color: black");
		texetAreaBox.setAlignment(Pos.CENTER);
		texetAreaBox.setSpacing(10);
		localGuiBox.getChildren().add(texetAreaBox);
		localGuiBox.getChildren().add(new Separator());

		// demonstrate Slider
		slider = new Slider(0, 100, 50); // max, min, value
		sliderLabel = new Text("Truncated Slider Results: ");
		sliderResults = new Text();
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(25);
		slider.valueProperty().addListener(this::respondToSlider); // code to
																	// listen
																	// for
																	// changes
																	// in value
		// double value = slider.valueProperty().getValue().doubleValue();
		// code to just get the value

		HBox sliderResultsBox = new HBox(sliderLabel, sliderResults);
		sliderResultsBox.setAlignment(Pos.CENTER);
		sliderResultsBox.setSpacing(5);

		VBox sliderBox = new VBox(slider, sliderResultsBox);
		sliderBox.setAlignment(Pos.CENTER);
		sliderBox.setSpacing(10);
		sliderBox.setStyle("-fx-border-color: black");
		localGuiBox.getChildren().add(sliderBox);
		localGuiBox.getChildren().add(new Separator());

		// demonstrate ComboBox
		stateComboBox = new ComboBox<String>();
		stateComboBox.getItems().addAll("New York", "California", "Alaska", "Hawaii");
		stateComboBox.getSelectionModel().selectedItemProperty().addListener(this::selectState);
		stateResult = new Text("");

		VBox stateBox = new VBox(stateComboBox, stateResult);
		stateBox.setAlignment(Pos.CENTER);
		stateBox.setSpacing(10);
		stateBox.setStyle("-fx-border-color: black");
		localGuiBox.getChildren().add(stateBox);
		localGuiBox.getChildren().add(new Separator());

		// demonstrate ListView
		Text fruitLabel = new Text("Enter a fruit:");
		fruitField = new TextField("");
		fruitButton = new Button("Add Fruit and Shuffle");
		fruitButton.setOnAction(this::addFruit);

		fruitListView = new ListView<String>();
		ArrayList<String> fruitList = new ArrayList<String>();
		fruitList.add("apple");
		fruitList.add("banana");
		fruitList.add("canteloupe");
		fruitList.add("pear");
		fruitList.add("orange");
		Collections.shuffle(fruitList);

		fruitSelectedText = new Text("");

		fruitListView.setItems(FXCollections.observableArrayList(fruitList));
		fruitListView.setPrefWidth(100);
		fruitListView.setPrefHeight(100);
		fruitListView.getSelectionModel().selectedItemProperty().addListener(this::selectFruit);

		VBox fruitBox = new VBox(fruitLabel, fruitField, fruitButton, fruitListView, fruitSelectedText);
		fruitBox.setAlignment(Pos.CENTER);
		fruitBox.setSpacing(10);
		fruitBox.setStyle("-fx-border-color: black");
		fruitBox.setPadding(new Insets(10, 10, 20, 10));
		localGuiBox.getChildren().add(fruitBox);

		return localGuiBox;
	}

	private void respondToSlider(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
		String output = Integer.toString((int) newValue.doubleValue());
		sliderResults.setText(output);
	}

	private void addFruit(ActionEvent event) {
		String fruit = fruitField.getText();
		fruitField.clear();
		fruitListView.getItems().add(fruit);
		Collections.shuffle(fruitListView.getItems());
		
	}
	public void method() {
	    System.out.println();
	}
	

	private void selectState(ObservableValue<? extends String> ov, String oldVal, String newVal) {
		stateResult.setText("You chose: " + newVal);
	}

	private void selectFruit(ObservableValue<? extends String> ov, String oldVal, String newVal) {
		fruitSelectedText.setText("You chose: " + newVal);
	}

	private void selectMenuItem(ActionEvent event) {
		if (event.getSource() == dogItem) {
			if (!primaryBox.getChildren().contains(dogBox)) {
				primaryBox.getChildren().remove(guiBox);
				primaryBox.getChildren().add(dogBox);
			}
		} else if (event.getSource() == guiItem) {
			if (!primaryBox.getChildren().contains(guiBox)) {
				primaryBox.getChildren().remove(dogBox);
				primaryBox.getChildren().add(guiBox);
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
