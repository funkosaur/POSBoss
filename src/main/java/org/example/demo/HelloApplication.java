package org.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Controller.AfterLogin;
import Controller.BeersScreen;
import Controller.CreateOrder;
import Controller.HelloController;
import Model.Order;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HelloApplication extends Application {

    private static Stage primaryStage;

    public static List<Order> OrdersArrayList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        HelloApplication.primaryStage = primaryStage;
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT); // Load the hello-view.fxml file with the HelloController
        loadHelloView();

        // Show the stage and then center it
        primaryStage.show();

        // Center the stage on the screen
        centerStageOnScreen(primaryStage);
    }

    public static void changeScene(String fxml) throws IOException {
        // Load the specified FXML file and set the scene
        if (fxml.equals("afterLogin.fxml")) {
            centerStageOnScreen(primaryStage);
            primaryStage.setX(0);
            primaryStage.setY(0);
            loadAfterLogin();
        } else if (fxml.equals("hello-view.fxml")) {
            centerStageOnScreen(primaryStage);
            loadHelloView();
        } else if (fxml.equals("createOrder.fxml")) {
            centerStageOnScreen(primaryStage);
            loadCreateOrder();
        } else if (fxml.equals("beersScreen.fxml")) {
            loadBeersScreen();
        }
    }

    private static void loadHelloView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent pane = fxmlLoader.load();
        primaryStage.setScene(new Scene(pane));

        // Set the HelloController and initialize it
        HelloController helloController = fxmlLoader.getController();
        helloController.setStage(primaryStage);
        centerStageOnScreen(primaryStage);
    }

    private static void loadCreateOrder() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("createOrder.fxml"));
        Parent pane = fxmlLoader.load();

        // Set the scene and AfterLogin controller
        primaryStage.setScene(new Scene(pane));
        CreateOrder createOrderController = fxmlLoader.getController();
        createOrderController.setStage(primaryStage);
        createOrderController.setFullScreen();
        //centerStageOnScreen(stg);
    }

    private static void loadAfterLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("afterLogin.fxml"));
        Parent pane = fxmlLoader.load();

        // Set the scene and AfterLogin controller
        primaryStage.setScene(new Scene(pane));
        AfterLogin afterLoginController = fxmlLoader.getController();
        afterLoginController.setStage(primaryStage);
        afterLoginController.setFullScreen();
        //centerStageOnScreen(stg);
        //stg.setWidth(Screen.getPrimary().getVisualBounds().getWidth()); yy
        //stg.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
        //SHOW THEM WHAT HAPPENS!!!!!
    }

    private static void loadBeersScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("beersScreen.fxml"));
        Parent pane = fxmlLoader.load();
        Stage beersScreenStage = new Stage();
        beersScreenStage.initOwner(primaryStage);
        beersScreenStage.initModality(Modality.WINDOW_MODAL);
        beersScreenStage.initStyle(StageStyle.TRANSPARENT);
        beersScreenStage.setScene(new Scene(pane));

        // Set the BeersScreen controller and initialize it
        BeersScreen beersScreenController = fxmlLoader.getController();
        beersScreenController.setStage(beersScreenStage);

        double topRightX = 1120;
        double topRightY = 35;

        // Set the X coordinate directly to ensure consistent positioning
        beersScreenStage.setX(topRightX);
        beersScreenStage.setY(topRightY);

        // Show the BeersScreen stage
        beersScreenStage.show();
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

    public static BeersScreen getBeersScreenController() {
        // Retrieve the FXMLLoader instance for beersScreen.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("beersScreen.fxml"));
        try {
            // Load the root element (Parent) of beersScreen.fxml
            Parent pane = fxmlLoader.load();
            
            // Retrieve the controller associated with beersScreen.fxml
            BeersScreen beersScreenController = fxmlLoader.getController();
            
            // Return the controller instance
            return beersScreenController;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        launch();
    }
}
