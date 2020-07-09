import java.util.Random;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class RectangleColorChangeGUI extends Application {

    private final static int WIDTH = 200, HEIGHT = 200;
    private Button colorButton;
    private Rectangle rectangle;
    boolean outlinedInBlack = false;
    
    private int count = 0;

    public void start(Stage primaryStage) {
        VBox mainBox = new VBox();
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(10);
        mainBox.setStyle("-fx-background-color: white");
  
        this.colorButton = new Button("Click Here");
      
        
        // assigning the button behavior with a method reference- haven't covered this yet!
        //colorButton.setOnAction(this::handleButtonClick);
        
        // let's use an anonymous class
        // the setOnAction method requires an object of type EventHandler<T extends Event>
        /*
        colorButton.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                handleButtonClick(event);
            }
            
        });
        */
        
        /* example of labmda without the count
        // use a lambda to link up the button action
        colorButton.setOnAction(
            (ActionEvent event) -> handleButtonClick(event)
            // could be (ActionEvent event)
            // could be (event)
            // could be event
            // could be ActionEvent event
        );
        */
        
        // allowed to declare a local variable in this way and use it inside the lambda
         int myFavoriteNumber = 5; // not declared as final, but not changed, so it is "effectively" final
        // final int myFavoriteNumber = 5;
        
        // not allowed! myFavoriteNumber is no longer "effectively final" so I cannot use it in the lambda
        //int myFavoriteNumber = 5;
        //myFavoriteNumber = 13;
        colorButton.setOnAction(
                (ActionEvent event) -> {
                    this.count++;
                    handleButtonClick(event);
                    System.out.println(count);
                    if(count==myFavoriteNumber) {
                        System.out.println("Hoorah!");
                    }
                    
                });
              
        
        mainBox.getChildren().add(colorButton);

        rectangle = new Rectangle(50, 50, 100, 100);
        rectangle.setFill(Color.BLUE);
        mainBox.getChildren().add(rectangle);

        Scene scene = new Scene(mainBox, WIDTH, HEIGHT, Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Color Change!");
        primaryStage.show();
    }

    public void handleButtonClick(ActionEvent event) {
        changeRectangleColor();
    }

    private void changeRectangleColor() {
        Random generator = new Random();
        rectangle.setFill(Color.rgb(generator.nextInt(255), generator.nextInt(255), generator.nextInt(255)));
    }
    public static void main(String[] args) {
        launch(args);

    }

}
