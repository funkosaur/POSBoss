package org.example.demo;

import java.io.IOException;

//import org.controlsfx.control.StatusBar;
//import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {

    public HelloController() {

    }

    @FXML
    private Button button;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
        HelloApplication m = new HelloApplication();
        if (username.getText().toString().equals("123") && password.getText().toString().equals("123")) {

            //FALI SVAŠTAAA//
            m.changeScene("afterLogin.fxml");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {

            //FALII SVAŠTAAA//
        } else {

            //FALII SVAŠTAA//
        }
    }

}
