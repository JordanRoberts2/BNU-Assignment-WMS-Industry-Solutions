package model;

public class Product {
    private int id;
    private String name;
    private int price;
    private int stockLevel;

    public Product(String name, int id, int price, int stockLevel) {
        this.name = name;
        this.id = id;
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

}