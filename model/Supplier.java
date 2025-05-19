package model;

public class Supplier {

    private int id;
    private String name;
    private String contact;
    // order history tbc

    public Supplier(int id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    } 
//Getter and setter for ID
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//Getter and setter for Name
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
// Getter and setter for Contact

    public String getContact(){
        return contact;
    }
    
    public void setContact(String contact){
        this.contact = contact;
    }
}