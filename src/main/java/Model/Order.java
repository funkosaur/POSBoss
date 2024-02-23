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