package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.example.demo.dbAccess;

public class Order {
    // i'll set all variables at public. for the sake of the project we'll make them private with getters and setters later
    public int orderID = 0;
    // public Products product;
    public ArrayList<Products> productz = new ArrayList<>();
    public double priceOfOrder;
    public String orderMessage = "";

    public Order(double priceOfOrder, int orderID){
        orderID++;
        this.priceOfOrder = 0.0;
        this.orderMessage = "";
        this.orderID = orderID;
    }

    public synchronized Products getDetails()
        //  throws StockException
  {
    try
    {
        dbAccess   derbyAccess = new dbAccess();
        derbyAccess.loadDriver();
        Connection theconn = DriverManager.getConnection(derbyAccess.urlOfDatabase());
        Statement stmt = theconn.createStatement();
        Products prd = new Products("", 0.0, "");
        ResultSet rs = stmt.executeQuery(
        "select name, description, cost, productType " +
        "  from roductsTable, stockTable " +
        "  where  productsTable.name = '" + this.label.getName() + "' " +
        "  and    stockTable.name   = '" + this.label.getName() + "'"
        );
        if ( rs.next() )
        {
            prd.setName(rs.getString("name"));
            prd.setDescription(rs.getString( "description" ) );
            prd.setCost( rs.getDouble( "cost" ) );
            prd.setProductType(ProductType.valueOf(rs.getString("productType")));
        }
      rs.close();
      return prd;
    } catch ( SQLException e )
    {
       System.out.println(( "SQL getDetails: " + e.getMessage() ));
    }
  }
    // method to write in the white textbox
    public String writeInTextBox() {
    Locale uk = Locale.UK;
    StringBuilder sb = new StringBuilder(256);
    String csign = (Currency.getInstance(uk)).getSymbol();
    double total = 0.00;
    if (orderID != 0)
        sb.append("Order number: ").append(orderID).append("\n");

    if (orderID > 0) {
        Map<String, List<Products>> groupedProducts = this.stream()
            .collect(Collectors.groupingBy(Products::getProductNum));

        for (Map.Entry<String, List<Products>> entry : groupedProducts.entrySet()) {
            int number = entry.getValue().stream().mapToInt(Products::getQuantity).sum();
            Products pr = entry.getValue().get(0);
            sb.append(pr.getProductNum()).append(" ");
            sb.append(pr.getDescription()).append(" ");
            sb.append("(").append(number).append(") ");
            sb.append(csign).append(pr.getCost() * number).append("\n");
            total += pr.getCost() * number;
        }
        sb.append("----------------------------\n");
        sb.append("Total ").append(csign).append(total).append("\n");
    }
    return sb.toString();
}


    // method to add product items to the order
    public void addProduct (){
        // needs implementation
        if !(calculatorTexfield.getText()).equals("") {                         // check if there is anything in the calculator checkbox
            for( int i = 0; i < Integer.parseInt(calculatorTexfield.getText()); i++) {      // take that value, convert to int and iterate through it
                Products product = getDetails();

                //run the actual function which:
                //  1. makes a connection to derby db
                //  2. make a String variable ITEMNAME which contains the value of the label clicked. 
                //  3. perform a query on the derby db where the ITEMNAME matches the element in the name column
                if(product != null) {
                    productz.add(product);
                    priceOfOrder += product.getCost();
                    // here I can add the code that updates the fieldText with the product.getName() and use some sort of betterbasket to link it

                }
                
            }
        }
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
        // can be implemented similarly to what Ive done on the catshop receipt.
        return String.format("You have %.2f to pay", this.priceOfOrder);
    }


}