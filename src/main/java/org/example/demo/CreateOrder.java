package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Button;

public class CreateOrder {

    @FXML
    private Button goBack;


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
