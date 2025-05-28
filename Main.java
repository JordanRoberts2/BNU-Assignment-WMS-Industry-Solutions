import java.util.Scanner;

import model.Product;
import model.Supplier;
import model.SupplierManager;
import model.InventoryManager;
import model.Customer;

class Main {
    private static InventoryManager inventoryManager = new InventoryManager();
    private static SupplierManager supplierManager = new SupplierManager();


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

        //Creates a few products for BNU Industry Solutions Ltd., related to industrial equipment and supplies so the inventory is not empty at runtime.
        Product product1 = new Product("Drill", 101, 1500, 10);
        Product product2 = new Product("Helmet", 102, 500, 5);
        Product product3 = new Product("Safety Glasses", 103, 100, 100);
        Supplier supplier1 = new Supplier(1, "ABC Supplies", "555-6789");
        inventoryManager.addProduct(product1);
        inventoryManager.addProduct(product2); 
        inventoryManager.addProduct(product3);
        supplierManager.addSupplier(supplier1);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("--------------------------//");
            System.out.println("Welcome to the Warehouse Management System!");
            System.out.println("1. Add Product");
            System.out.println("2. Restock Product");
            System.out.println("3. View Inventory");
            System.out.println("4. Add Supplier");
            System.out.println("5. View Supplier");
            System.out.println("6. View all Suppliers");
            System.out.println("7. Delete Supplier");
            System.out.println("8. Update Supplier");// Not implemented
            System.out.println("9. Create Purchase Order"); // Not implemented - ask Copilot how to do this for

            //purchase order
            
           // System.out.println("7. Generate Finance Report");// Not implemented
           // System.out.println("8. Low stock");// Not implemented
           // System.out.println("0. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addProduct(scanner); // Add a new product
                case 2 -> restockProduct(scanner); // Restock a product
                case 3 -> viewInventory(scanner); // View the inventory
                case 4 -> addSupplierInfo(scanner); // Add a new supplier
                case 5 -> viewSupplierInfo(scanner); // View one supplier 
                case 6 -> supplierManager.printSupplierInfo(); // View all suppliers
                case 7 -> deleteSupplier(scanner); // Delete a supplier
                case 8 -> updateSupplier(scanner); // Update supplier information
                case 9 -> createPurchaseOrder(scanner); //Creates a purchase order to a supplier
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
    private static void viewInventory(Scanner scanner) {
        if (inventoryManager.isInventoryEmpty()) {
            System.out.println("Sorry, there are no products in the system. Please add a product first.");
            return;
        }
        System.out.println("Current Inventory:");
        inventoryManager.printInventory();
      
    } 

    // Method to add a supplier for case 4
    private static void addSupplierInfo(Scanner scanner) {
        System.out.print("Enter supplier name: ");
         String name = scanner.nextLine();
         System.out.print("Enter supplier contact details: ");
         String contact = scanner.nextLine();
          System.out.print("Enter supplier ID: ");
         int id = scanner.nextInt();  
       scanner.nextLine(); // Consume newline


         Supplier supplier = new Supplier(id, name, contact);
         //System.out.println("The supplier " + supplier.getName() + " has been added to the system.");
            if (supplierManager.addSupplier(supplier)) {
                System.out.println("Supplier added: " + supplier.getName());
            } else {
                System.out.println("Failed to add supplier. Please try again.");
            }
    }

        // Method to view supplier information for case 5
        private static void viewSupplierInfo(Scanner scanner) {
            System.out.println("Enter supplier name to view details: ");
            String name = scanner.nextLine();
            // Assuming we have a method in SupplierManager to get supplier by name
            Supplier supplier = supplierManager.getSupplier(name);
            if (supplier != null) {
                System.out.println("Here are the supplier details you have requested:");
                System.out.println("Supplier ID: " + supplier.getId());
                System.out.println("Name: " + supplier.getName());
                System.out.println("Contact: " + supplier.getContact());
            } else {
                System.out.println("Supplier not found.");
            }
        }
    
        private static void deleteSupplier(Scanner scanner) {
            System.out.print("Enter supplier ID to delete: ");
            int id = scanner.nextInt();
            if (supplierManager.deleteSupplier(id) != null) {
                System.out.println("Supplier deleted successfully.");
            } else {
                System.out.println("Supplier not found or could not be deleted.");
            }
        }

        // Method to update supplier information for case 8
        private static void updateSupplier(Scanner scanner) {
            System.out.print("Enter supplier ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new contact: ");
            String newContact = scanner.nextLine();

            Supplier updatedSupplier = supplierManager.updateSupplier(id, newName, newContact);
            if (updatedSupplier != null) {
                System.out.println("Supplier updated successfully.");
            } else {
                System.out.println("Supplier not found or could not be updated.");
            }
        }

         private static void createPurchaseOrder(Scanner scanner) {
            System.out.println()

         }

}