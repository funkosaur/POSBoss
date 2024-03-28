package Controller;

import java.io.IOException;

import javafx.application.Platform;
//import org.controlsfx.control.StatusBar;
//import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.demo.HelloApplication;

public class HelloController {

    private Stage stage;

    public HelloController() {

    }

    @FXML
    private Button button;
    @FXML
    private Button xbut;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        if (username.getText().equals("123") && password.getText().equals("123")) {
            HelloApplication.changeScene("afterLogin.fxml");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            // Handle empty fields
        } else {
            // Handle incorrect login
        }
    }
    
    @FXML
    public void userExit(ActionEvent event) throws IOException {
        Platform.exit();
    }

}
