package model;
// Customer now extends Person to show inheritance
public class Customer extends Person { 
    private int customerId;
    private String address;

    public Customer(int customerId, String name, String contact, String address) {
        super(name, contact);
        this.customerId = customerId;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
}
