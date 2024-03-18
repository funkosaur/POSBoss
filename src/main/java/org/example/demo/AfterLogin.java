package org.example.demo;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AfterLogin {

    @FXML
    private Button logout;

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

    @FXML
    public void userLogOut(ActionEvent event) throws IOException {
        HelloApplication.changeScene("hello-view.fxml");
    }

    // Add a method to set the stage to fullscreen
    public void setFullScreen() {
        if (stage != null) {
            stage.setFullScreen(true);
        }
    }

    @FXML
    public void createOrder(ActionEvent event) throws IOException {
        HelloApplication.changeScene("createOrder.fxml");
    }
    
    @FXML
     public void userExit(ActionEvent event) throws IOException {
        Platform.exit();
    }
}
