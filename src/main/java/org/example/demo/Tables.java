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

public class Tables {

    @FXML Button goBack;

    @FXML
    private Button createOrder;

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
}