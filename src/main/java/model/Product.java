package model;

public class Product {
    private static int nextProductId = 1;

    private int id;
    private String name;
    private int price;
    private int stockLevel;

    public Product(String name, int price, int stockLevel) {
        this.name = name;
        this.id = nextProductId++;
        this.price = price;
        this.stockLevel = stockLevel;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }     
    public void setName(String name){
        this.name = name;
    }

    public int getPrice(){
        return price;
    }
    
    public void setPrice(int price){
        this.price = price;
    }

    public int getStockLevel(){
        return stockLevel;
    }
    
    public void setStockLevel(int stockLevel){
        this.stockLevel = stockLevel;
    }
    // Method to add stock
    public void addStock(int amount) {
       if(amount > 0) {
            stockLevel += amount;
            System.out.println("Stock added successfully. New stock level: " + stockLevel);
        } else {
            System.out.println("Invalid amount. Cannot add stock.");
        }
       }
    // Method to remove stock
       public void removeStock(int amount) {
        if (stockLevel >= amount) {
            stockLevel -= amount;
            System.out.println("Stock removed successfully. New stock level: " + stockLevel);
        } else {
            System.out.println("Insufficient stock. Cannot remove " + amount + " items.");
        }
       }

    // Method to check stock level
       public void checkStock() {
        System.out.println("Id: " + id + ", Name: " + name + ", Quantity: " + stockLevel + ", Price: " + price);

       }

       //Low stock alert
         public void lowStockAlert() {
          if (stockLevel < 5) {
                System.out.println("Low stock alert for " + name + ". Current stock level: " + stockLevel);
          }
         }
    }