package Model;

public class User {
    public int userID;
    public String name;
    public String password;
    public UserRole userRole;

    public User(int userID, String name, String password, UserRole userRole) {
        this.userID = userID;
        this.name = name;
        this.password = password;;
        this.userRole = userRole;
    }

    //method to create order
    public void createOrder() {
        // code to implemennt here
    }

    //method to split bill. for now I will divide by the number of guests, but later can look at better implementations
    public double splitBill(int numberOfGuests) {
        return 0;
        // implement this. consider if it actually needs to be here, since this needs to access the bill 
    }

}
