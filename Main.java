import java.util.Scanner;

import model.Product;
import model.InventoryManager;
import model.Customer;

class Main {
    private static InventoryManager inventoryManager = new InventoryManager();

    // Main method to run the Warehouse Management System
    public static void main(String[] args) {
        // Create a Customer
        Customer customer = new Customer(1, "Alice Smith", "555-1234", "123 Main St");

        // Access and print fields
        System.out.println("Customer ID: " + customer.getCustomerId());
        System.out.println("Name: " + customer.getName());
        System.out.println("Contact: " + customer.getContact());
        System.out.println("Address: " + customer.getAddress());

        // Modify and print again
        customer.setAddress("456 Elm St");
        System.out.println("Updated Address: " + customer.getAddress());

        //Create a few relevant products for BNU Industry Solutions Ltd., related to industrial equipment and supplies so the inventory is not empty at the start
        Product product1 = new Product("Drill", 101, 1500, 10);
        Product product2 = new Product("Helmet", 102, 500, 5);
        Product product3 = new Product("Safety Glasses", 103, 100, 100);
        inventoryManager.addProduct(product1);
        inventoryManager.addProduct(product2); 
        inventoryManager.addProduct(product3);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("--------------------------//");
            System.out.println("Welcome to the Warehouse Management System!");
            System.out.println("1. Add Product");
            System.out.println("2. Restock Product");
            System.out.println("3. View Inventory");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addProduct(scanner);
                case 2 -> restockProduct(scanner);
                case 3 -> {
                System.out.println("Here is a list of the items currently in the warehouse stock:");    
                inventoryManager.printInventory();
                }
            }
        } while (choice != 0);
        System.out.println("Exiting the system. Goodbye!");
        System.out.println("--------------//");

    }
    
    // Method to add a new product for case 1
    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter product price: ");
        int price = scanner.nextInt();
        System.out.print("Enter stock level: ");
        int stockLevel = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = new Product(name, id, price, stockLevel);
        if (inventoryManager.addProduct(product)) {
            System.out.println("Product added: " + product.getName());
        } else {
            System.out.println("Failed to add product. Inventory might be full. Please try again.");
        }
    } 
    
    // Method to restock a product for case 2
    private static void restockProduct(Scanner scanner) {
        if (inventoryManager.isInventoryEmpty()) {
            System.out.println("Sorry, there are no products in the system. Please add a product first.");
            return;
        }

        System.out.println("Current Inventory:");
        inventoryManager.printInventory();
        
        System.out.print("Enter the ID of the product you want to restock: ");
        int productId = scanner.nextInt();
        System.out.print("Enter the quantity to add: ");
        int quantity = scanner.nextInt();

        inventoryManager.restockProduct(productId, quantity);
    }

    // Method to print the inventory for case 3
    private static void printInventory(Scanner scanner) {
        if (inventoryManager.isInventoryEmpty()) {
            System.out.println("Sorry, there are no products in the system. Please add a product first.");
            return;
        }
        inventoryManager.printInventory();
    }


}