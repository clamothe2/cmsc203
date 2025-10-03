package lab2;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class FXDriver extends Application {
    
    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        // Student Task #1 - Create an instance of FXMainPane called root
        FXMainPane root = new FXMainPane();
        
        // Student Task #1 - Set the scene with width and height
        stage.setScene(new Scene(root, 400, 200));
        
        // Show the stage
        stage.show();
    }
}