package model;

// Supplier now extends Person to show inheritance
public class Supplier extends Person {
    private static int nextSupplierId = 0; // Static counter for unique IDs
    private int id;

    public Supplier(String name, String contact) {
        super(name, contact);
        this.id = ++nextSupplierId;
    }

// Getter and setter for ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void clearID(){
        nextSupplierId = 0;
    }
}