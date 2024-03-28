package Model;


public class Products {
    public String name;
    public double cost;
    public ProductType productType;
    public String description;
    

    public Products (String name, double cost, String description){
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    // getters for the attributes
    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    public ProductType getProductType() {
        return this.productType;
    }
    public String getDescription() {
        return this.description;
    }
    // setters - setters are important as its whith this that we can actually add info to products in the orders arraylist
    public void setName (String newName) {
        this.name = newName;
    }
    public void setCost (double newCost) {
        this.cost = newCost;
    }
    public void setProductType (ProductType newProdType) {
        this.productType = newProdType;
    }
    public void setDescription(String newDesc) {
        this.description = newDesc;
    }
}
