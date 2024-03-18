package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
//import java.io.IOException;
import javafx.scene.control.Button;

public class BeersScreen {

    @FXML
    private Button backBut;

    private Stage stage;

    // Inject the Stage into the controller
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        // Initialize here sometimes
    }

    @FXML
    public void goBack(ActionEvent event) {
        // Close the BeersScreen window
        stage.close();
    }
}