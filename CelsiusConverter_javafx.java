
// Input Text field: user can type in a temperature in Celsius
// Input Button: title "Convert"; user taps button:
    //value in text field converts to Fahrenheit
    //displays in a Label

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class CelsiusConverter_javafx extends Application
{
    //Create the Message Label
    Label print_label = new Label("Fahrenheit:\t\t\t32 Degrees");
    
    public static void main(String[]args)
    {
        Application.launch(args);
    }

    public void start(Stage stage)
    {

        //Create the Text Fields
        TextField convert_field = new TextField();
        //Create the Labels
        Label convert_label = new Label();
        //Bind the Label to the according Field
        convert_label.setLabelFor(convert_field);

        //Set field wide enough to display 15 chars
        convert_field.setPrefColumnCount(15);
        //Set mnemonic parsing to the Label
        convert_label.setMnemonicParsing(true);

        //Create button
        Button convert_button = new Button("Convert");
        //Add EventHandler to the Button

        convert_button.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                
                //Users input
                String input;

                double fahrenheit;

                //Get user input
                input = convert_field.getText();

                //Convert input to fahrenheit
                fahrenheit = (Double.parseDouble(input) * (1.8)) + 32;

                printLabel("Fahrenheit:\t\t\t" + fahrenheit + " Degrees");
            }
        });

        //Create the HBox
        HBox button_frame = new HBox();
        //Add the children to the HBox
        button_frame.getChildren().addAll(convert_button);
        //Set the vertical spacing between children to 15px
        button_frame.setSpacing(15);

        //Create the VBox
        VBox base = new VBox();
        //Add the children to the VBox
        base.getChildren().addAll(convert_field, button_frame, print_label);
        //Set the vertical spacing between children to 15px
        base.setSpacing(15);
        //Set the Size of the VBox;
        base.setMinSize(350, 250);

         /*
        Set the padding, border-style, border-width, 
        border-insets, border-radius and border-color
        */

        base.setStyle("-fx-padding: 10;" +
            "-fx-border-style: dotted inside;" +
            "-fx-border-width: 3;" +
            "-fx-border-insets: 5;" +
            "-fx-border-radius: 5;" +
            "-fx-border-color: lightblue");

        //Create the Scene
        Scene scene = new Scene(base);
        //Add the scene to the Stage
        stage.setScene(scene);
        //Set the title of the Stage
        stage.setTitle("Celsius Converter");
        //Display the Stage
        stage.show();
    }

    public void printLabel(String print)
    {
        //Set the Text of the Label
        print_label.setText(print);
    }
}

