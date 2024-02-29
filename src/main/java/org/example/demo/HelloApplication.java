package org.example.demo;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stg = primaryStage;
        primaryStage.setResizable(false);

        // Load the hello-view.fxml file with the HelloController
        loadHelloView();

        // Show the stage and then center it
        primaryStage.show();

        // Center the stage on the screen
        centerStageOnScreen(primaryStage);
    }

    public static void changeScene(String fxml) throws IOException {
        // Load the specified FXML file and set the scene
        if (fxml.equals("afterLogin.fxml")) {
            centerStageOnScreen(stg);
            stg.setX(0);
            stg.setY(0);
            loadAfterLogin();
        } else if (fxml.equals("hello-view.fxml")) {
            centerStageOnScreen(stg);
            loadHelloView();
        } else if (fxml.equals("createOrder.fxml")) {
            centerStageOnScreen(stg);
            loadCreateOrder();
        }
    }

    private static void loadHelloView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent pane = fxmlLoader.load();
        stg.setScene(new Scene(pane));

        // Set the HelloController and initialize it
        HelloController helloController = fxmlLoader.getController();
        helloController.setStage(stg);
        centerStageOnScreen(stg);
    }

    private static void loadCreateOrder() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("createOrder.fxml"));
        Parent pane = fxmlLoader.load();

        // Set the scene and AfterLogin controller
        stg.setScene(new Scene(pane));
        CreateOrder createOrderController = fxmlLoader.getController();
        createOrderController.setStage(stg);
        createOrderController.setFullScreen();
        //centerStageOnScreen(stg);

    }

    private static void loadAfterLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("afterLogin.fxml"));
        Parent pane = fxmlLoader.load();

        // Set the scene and AfterLogin controller
        stg.setScene(new Scene(pane));
        AfterLogin afterLoginController = fxmlLoader.getController();
        afterLoginController.setStage(stg);
        afterLoginController.setFullScreen();
        //centerStageOnScreen(stg);
        //stg.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        //stg.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
        //SHOW THEM WHAT HAPPENS!!!!!
    }

    private static void centerStageOnScreen(Stage stage) {
        // Get the primary screen dimensions
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        // Center the stage on the screen
        double centerX = bounds.getMinX() + (bounds.getWidth() - stage.getWidth()) / 2;
        double centerY = bounds.getMinY() + (bounds.getHeight() - stage.getHeight()) / 2;

        stage.setX(centerX);
        stage.setY(centerY);
    }

    public static void main(String[] args) {
        launch();
    }
}
