package org.example.demo;

import java.io.IOException;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CreateOrder {

    @FXML
    private Button goBack;

    @FXML
    private Label result;

    @FXML
    private Button xbut;

    private Stage stage;

    // Inject the Stage into the controller
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        // Optionally, you can set other properties or perform initialization here
    }

    public void setFullScreen() {
        if (stage != null) {
            stage.setFullScreen(true);
        }
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {
        HelloApplication.changeScene("afterLogin.fxml");
    }

    @FXML
    public void goToBeers(ActionEvent event) throws IOException {
        HelloApplication.changeScene("beersScreen.fxml");
    }

    // Event handler for calculator buttons
    @FXML
    public void handleCalculatorButton(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button clickedButton = (Button) event.getSource();
            String buttonText = clickedButton.getText();

            // Create a ScaleTransition for the button
            ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.2), clickedButton);
            scaleTransition.setFromX(1);
            scaleTransition.setToX(0.8);
            scaleTransition.setFromY(1);
            scaleTransition.setToY(0.8);
            scaleTransition.setCycleCount(2);  // You can adjust this to control the number of cycles
            scaleTransition.setAutoReverse(true);

            // Play the scale transition
            scaleTransition.play();

            // Check if the current text is "0" and replace it with the new button's text
            // result.setText(buttonText);
            // Button press logic
            if (buttonText.equals(".") && result.getText().contains(".")) {
                return;
            } else {
                // Append the pressed button text to the label
                result.setText(result.getText() + buttonText);
            }
        }
    }

    // Event handler for DEL button
    @FXML
    public void handleDelButton(ActionEvent event) {
        String currentText = result.getText();
        Button clickedButton = (Button) event.getSource();
        if (!currentText.isEmpty()) {
            // Remove the last character from the calcScreen Label
            result.setText(currentText.substring(0, currentText.length() - 1));
        }
        // Create a ScaleTransition for the button
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.2), clickedButton);
        scaleTransition.setFromX(1);
        scaleTransition.setToX(0.8);
        scaleTransition.setFromY(1);
        scaleTransition.setToY(0.8);
        scaleTransition.setCycleCount(2);  // You can adjust this to control the number of cycles
        scaleTransition.setAutoReverse(true);

        // Play the scale transition
        scaleTransition.play();
    }

    // Event handler for C button
    @FXML
    public void handleCButton(ActionEvent event) {
        // Clear the calcScreen Label
        result.setText("");
        Button clickedButton = (Button) event.getSource();

        // Create a ScaleTransition for the button
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.2), clickedButton);
        scaleTransition.setFromX(1);
        scaleTransition.setToX(0.8);
        scaleTransition.setFromY(1);
        scaleTransition.setToY(0.8);
        scaleTransition.setCycleCount(2);  // You can adjust this to control the number of cycles
        scaleTransition.setAutoReverse(true);

        // Play the scale transition
        scaleTransition.play();
    }

    @FXML
    public void userExit(ActionEvent event) throws IOException {
        Platform.exit();
    }

}
