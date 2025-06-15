package src.model;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
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

        public List<Product> getLowStockProducts(int threshold) {
        List<Product> lowStock = new ArrayList<Product>();
        for (Product product : productList) {
            if (product.getStockLevel() <= threshold) {
                lowStock.add(product);
            }
        }
        return lowStock;
    }
}
