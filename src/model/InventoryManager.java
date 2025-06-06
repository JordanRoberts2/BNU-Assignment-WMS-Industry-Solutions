package src.model;

import java.util.ArrayList;

public class InventoryManager {
    /*private final int MAX_PRODUCTS = 100;
    private Product[] products = new Product[MAX_PRODUCTS];
    private int productCount = 0;

    public boolean addProduct(Product product) {
        if (productCount < MAX_PRODUCTS) {
            products[productCount++] = product;
            System.out.println("Product Count: " + p);
            return true;
        }
        return false;
    }

    public boolean isInventoryEmpty() {
        return productCount == 0;
    }

    public Product findProductById(int id) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getId() == id) {
                return products[i];
            }
        }
        return null;
    }
*/
    public static InventoryManager inventoryManager = new InventoryManager();
    private ArrayList<Product> productList = new ArrayList<>();
    
    private int productCount = 0;
    //add product function
    public boolean addProduct(Product product) {
        productList.add(product);
        productCount++;
        return true;
    }

public Product findProductById(int Id) {
    for (Product product : productList) {
        if (product.getId() == Id) {
            return product;
        }
    }
    return null;
}
 public boolean isInventoryEmpty() {
        return productCount == 0;
    }

    public void restockProduct(int productId, int quantity) {
        Product product = findProductById(productId);
        if (product != null) {
            product.addStock(quantity);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

     public void decreaseProduct (int productId , int quantity) {
        Product product = findProductById(productId);
        if (product != null) {
            product.removeStock(quantity);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public void printInventory() {
        if (productCount == 0) {
            System.out.println("The inventory is currently empty. Please add a product first.");
        } else {
            for (Product product : productList) {
                System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Stock: " + product.getStockLevel() + ", Price: " + product.getPrice());
            }
        }
    }
}
