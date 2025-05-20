import java.util.Scanner;

import model.Product;

class Main {
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
                //case 3 -> inventoryManager.printInventory(scanner);
            }
        } while (choice != 0);
        System.out.println("Exiting the system. Goodbye!");
        System.out.println("--------------//");

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

        Product product = new Product(name, id, price, stockLevel);
        System.out.println("Product added: " + product.getName());
    }

    private static void restockProduct(Scanner scanner) {
        //Some kind of loop checking that there is at least 1 existing product to return in a list, otherwise, show error message saying 'sorry, there are no products in the system. Please add a product first'
        System.out.print("Which product do you want to restock?:");
        String name = scanner.nextLine();
        System.out.print("How many items do you want to add to...");
        int addProduct = scanner.nextInt();

    }
}