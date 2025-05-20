import java.util.Scanner;

import model.Product;
import model.InventoryManager;

class Main {
    private static InventoryManager inventoryManager = new InventoryManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("--------------//");
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
                case 3 -> inventoryManager.printInventory();
            }
        } while (choice != 0);
        System.out.println("Exiting the system. Goodbye!");
        System.out.println("--------------//");

    }

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
            System.out.println("Failed to add product. Inventory might be full.");
        }
    }

    private static void printInventory(Scanner scanner) {
        if (inventoryManager.isInventoryEmpty()) {
            System.out.println("Sorry, there are no products in the system. Please add a product first.");
            return;
        }
        inventoryManager.printInventory();
    }
}