package Model;

import java.util.ArrayList;

public class Order {
    private static int nextOrderID = 0;

    private int orderID;
    private ArrayList<Products> products;
    private double price;
    private String orderMessage;

    public Order() {
        this.orderID = ++nextOrderID;
        this.products = new ArrayList<>();
        this.price = 0;
        this.orderMessage = "";
    }

    public void createOrder() {
        // Assuming you have created an Order object in this method
        Order order = new Order();

        // Add the order to the OrderRepository
        OrderRepository.addOrder(order);
    }

    public int getOrderID() {
        return orderID;
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void addProduct(Products product) {
        products.add(product);
        // Update price or perform any other necessary actions
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
        products.remove(products.size() -1);
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
        price = price - ( discountAmount / 100);
    }

    // method to process payment
    public String processPayment() {
        // returns a string with the bill of that specific table
        return String.format("You have %.2f to pay", this.price);
    }


}