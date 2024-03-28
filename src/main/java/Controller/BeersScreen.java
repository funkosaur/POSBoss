package Controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BeersScreen {

    @FXML
    private VBox beersContainer; // Container for beer buttons

    private Stage stage;

    // Setter method to inject the beersContainer
    public void setBeersContainer(VBox beersContainer) {
        this.beersContainer = beersContainer;
    }

    // Inject the Stage into the controller
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        // Initialize here sometimes
        showBeers(null);
    }

    @FXML
    public void goBack(ActionEvent event) {
        // Close the BeersScreen window
        stage.close();
    }

    @FXML
    public void showBeers(ActionEvent event) {
        // Clear previous buttons if any
        beersContainer.getChildren().clear();

        // Create an ArrayList with beer names
        ArrayList<String> beers = new ArrayList<>();
        beers.add("Heineken");
        beers.add("Budweiser");
        beers.add("Staropramen");
        beers.add("Đuljka");
        beers.add("Karlovačko");
        beers.add("Ožujsko");
        // Add more beers as needed...

        // Generate buttons for each beer
        for (int i = 0; i < beers.size(); i++) {
            String beer = beers.get(i);
            Button beerBut = new Button(beer);
            beerBut.setId("beer_" + beer.toLowerCase()); // Assigning an ID based on the beer name
            //beerBut.setOnAction(e -> handleBeerButtonClick(e)); HOW TO ADD METHODS TO THE GENERATED BUTTONS
            // Set size and position of the button
            beerBut.setLayoutX(100); // Set the X coordinate of the button
            beerBut.setLayoutY(50 + i * 50); // Set the Y coordinate of the button (offset based on index)
            beerBut.setPrefWidth(200); // Set the preferred width of the button
            beerBut.setPrefHeight(40); // Set the preferred height of the button
            beerBut.setCursor(Cursor.HAND);

            // Add button to the container
            beersContainer.getChildren().add(beerBut);
        }
    }

}
