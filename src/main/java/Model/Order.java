package Model;

import java.util.ArrayList;

public class Order {
    // i'll set all variables at public. for the sake of the project we'll make them private with getters and setters later
    public int orderID;
    // public Products product;
    public ArrayList<Products> productz = new ArrayList<>();
    public double priceOfOrder;
    public String orderMessage = "";

    public Order(int orderID, double priceOfOrder){
        this.orderID = orderID;
        this.priceOfOrder = priceOfOrder;
        this.orderMessage = "";
    }

    // method to add product items to the order
    public void addProduct (){
        // needs implementation
    }

    // method to remove products from an order
    public void removeProduct() {
        // requires implementaiton
        // iterate through the productz arraylist (for pr: productz) and where pr.getName().equals(something here) then it deletes it from the productz 
    }
    public void removeLastProduct() {
        productz.remove(productz.size() -1);
    }
 
    // method to add a message related to the order. such as "alergic to cheese"
    public void addMessage(String message) {
        // requires implementation
        this.orderMessage = message;
    }

    //method to get the price of individual items
    public double getPrice() {
        return 12.5; //requires implementation
    }

    // method to add discount to order
    public void addDiscount(int discountAmount) {
        // adds a discount to the order. will affect the total order price
        priceOfOrder = priceOfOrder - ( discountAmount / 100);
    }

    // method to process payment
    public String processPayment() {
        // returns a string with the bill of that specific table
        return String.format("You have %.2f to pay", this.priceOfOrder);
    }


}