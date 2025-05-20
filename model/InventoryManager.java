package model;

public class InventoryManager {
    private final int MAX_PRODUCTS = 100;
    private Product[] products = new Product[MAX_PRODUCTS];
    private int productCount = 0;

    public boolean addProduct(Product product) {
        if (productCount < MAX_PRODUCTS) {
            products[productCount++] = product;
            return true;
        }
        return false;
    }
public void printInventory() {
        if (productCount == 0) {
            System.out.println("Inventory is empty.");
        } else {
            for (int i = 0; i < productCount; i++) {
               // products[i].printDetails();
            }
        }
    }
}
    
    //Track and manage stock levels.
//• Receive new inventory and update stock quantities.
//• Monitor low stock alerts to prevent stockouts.