public class Order {
    // i'll set all variables at public. for the sake of the project we'll make them private with getters and setters later
    public int orderID;
    public Products product;
    public double priceOfOrder;

    public Order(int orderID, Products product, double priceOfOrder){
        this.orderID = orderID;
        this.product = product;
        this.priceOfOrder = priceOfOrder;
    }

    // method to add product items to the order
    public void addProduct (){
        // needs implementation
    }

    // method to remove products from an order
    public void removeProduct() {
        // requires implementaiton
    }

    // method to add a message related to the order. such as "alergic to cheese"
    public void addMessage() {
        // requires implementation
    }

    //method to get the price of individual items
    pubic double getPrice


}