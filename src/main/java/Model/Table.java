package Model;



public class Table {
    public int tableID;
    public Order order;
    public boolean tableStatus;

    public Table(){
        
    }

    //method to make the table avalable
    public void makeTableAvailable(int tableID) {
        this.tableStatus = true;
    }
}
