package model;

// Supplier now extends Person to demonstrate inheritance
public class Supplier extends Person {
    private int id;
    // order history tbc

    public Supplier(int id, String name, String contact) {
        super(name, contact);
        this.id = id;
    }
    // Getter and setter for ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}