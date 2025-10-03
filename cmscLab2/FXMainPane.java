package lab2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMainPane extends VBox {

    // Student Task #2 - Declare five buttons
    private Button helloButton;
    private Button howdyButton;
    private Button chineseButton;
    private Button clearButton;
    private Button exitButton;

    // Student Task #2 - Declare a label and textfield
    private Label feedbackLabel;
    private TextField textField;

    // Student Task #2 - Declare two HBoxes
    private HBox buttonBox;
    private HBox feedbackBox;

    // Student Task #4 - Declare DataManager instance at class level
    private DataManager dataManager;

    public FXMainPane() {
        // Student Task #4 - Instantiate DataManager in constructor
        dataManager = new DataManager();

        // Student Task #2 - Instantiate buttons with arguments
        helloButton = new Button("Hello");
        howdyButton = new Button("Howdy");
        chineseButton = new Button("Chinese");
        clearButton = new Button("Clear");
        exitButton = new Button("Exit");

        // Student Task #2 - Instantiate label with argument "Feedback:"
        feedbackLabel = new Label("Feedback:");

        // Student Task #2 - Instantiate textfield
        textField = new TextField();

        // Student Task #2 - Instantiate the HBoxes
        buttonBox = new HBox();
        feedbackBox = new HBox();

        // Student Task #4 - Set event handlers for buttons
        helloButton.setOnAction(new ButtonHandler());
        howdyButton.setOnAction(new ButtonHandler());
        chineseButton.setOnAction(new ButtonHandler());
        clearButton.setOnAction(new ButtonHandler());
        exitButton.setOnAction(new ButtonHandler());

        // Student Task #3 - Add buttons to buttonBox
        buttonBox.getChildren().addAll(helloButton, howdyButton, chineseButton,
                clearButton, exitButton);

        // Student Task #3 - Add label and textfield to feedbackBox
        feedbackBox.getChildren().addAll(feedbackLabel, textField);

        // Student Task #4 - Set margins for buttons
        HBox.setMargin(helloButton, new Insets(10));
        HBox.setMargin(howdyButton, new Insets(10));
        HBox.setMargin(chineseButton, new Insets(10));
        HBox.setMargin(clearButton, new Insets(10));
        HBox.setMargin(exitButton, new Insets(10));

        // Student Task #4 - Set margins for label and textfield
        HBox.setMargin(feedbackLabel, new Insets(10));
        HBox.setMargin(textField, new Insets(10));

        // Student Task #4 - Center the HBoxes
        buttonBox.setAlignment(Pos.CENTER);
        feedbackBox.setAlignment(Pos.CENTER);

        // Student Task #3 - Add HBoxes to the VBox (FXMainPane)
        getChildren().addAll(buttonBox, feedbackBox);
    }

    // Student Task #4 - Create inner class ButtonHandler
    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // Get the button that was clicked
            if (event.getTarget() == helloButton) {
                // Call DataManager's getHello method and display in textfield
                textField.setText(dataManager.getHello());
            } else if (event.getTarget() == howdyButton) {
                // Call DataManager's getHowdy method and display in textfield
                textField.setText(dataManager.getHowdy());
            } else if (event.getTarget() == chineseButton) {
                // Call DataManager's getChinese method and display in textfield
                textField.setText(dataManager.getChinese());
            } else if (event.getTarget() == clearButton) {
                // Clear the textfield
                textField.setText("");
            } else if (event.getTarget() == exitButton) {
                // Exit the application
                Platform.exit();
                System.exit(0);
            }
        }
    }
}