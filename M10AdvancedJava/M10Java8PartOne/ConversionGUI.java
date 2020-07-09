import javafx.scene.control.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class ConversionGUI extends Application {

    private TextField inputField;
    private Button convertButton;
    private ComboBox<ConversionType> conversionTypeBox;
    private Text resultText;

    public void start(Stage primaryStage) {
        System.setProperty("glass.accessible.force", "false");

        VBox primaryBox = new VBox();
        primaryBox.setAlignment(Pos.CENTER);
        primaryBox.setSpacing(20);
        primaryBox.setStyle("-fx-background-color: white");

        conversionTypeBox = new ComboBox<ConversionType>();
        ConversionType[] conversionTypeValues = ConversionType.values();
        for(ConversionType type : conversionTypeValues) {
            conversionTypeBox.getItems().add(type);
        }
        primaryBox.getChildren().add(conversionTypeBox);       

        Text inputLabel = new Text("Enter the input value:");
        inputField = new TextField();
        inputField.setMaxWidth(100);
        VBox inputBox = new VBox(inputLabel, inputField);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.setSpacing(20);
        primaryBox.getChildren().add(inputBox);
        
        convertButton = new Button("Convert");
        convertButton.setOnAction(
          (ActionEvent event) -> { // could also be written just as event 
          
              ConversionType typeSelected = conversionTypeBox.getValue();
              if(typeSelected != null && !inputField.getText().isEmpty()) {
                  double input = Double.parseDouble(inputField.getText());
                  
                  // Converter converter = ConverterFactory.createConverter(typeSelected);
                  Converter converter = Converter.createConverter(typeSelected);
                  double output = converter.convert(input);
                  resultText.setText(Double.toString(output));
                  
              } else {
                  resultText.setText("Error: all fields are required");
              }
                
                  
              
          }
        );
        
        VBox buttonBox = new VBox(convertButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(20);
        primaryBox.getChildren().add(buttonBox);
        
        Text resultLabel = new Text("Result:");
        resultText = new Text();
        VBox resultBox = new VBox(resultLabel, resultText);
        resultBox.setAlignment(Pos.CENTER);
        resultBox.setSpacing(20);
        primaryBox.getChildren().add(resultBox);


        Scene scene = new Scene(primaryBox, 300, 300);
        primaryStage.setTitle("Measurement Converter");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
  

    public static void main(String[] args) {
        launch(args);
    }
}
