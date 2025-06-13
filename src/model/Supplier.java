package src.model;

// Supplier now extends Person to show inheritance
public class Supplier extends Person {
    private static int nextSupplierId = 1; // Static counter for unique IDs
    private int id;
    // order history tbc

    public Supplier(String name, String contact) {
        super(name, contact);
        this.id = nextSupplierId++;
    }
    // Getter and setter for ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}