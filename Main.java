import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Product;
import model.PurchaseOrder;
import model.PurchaseOrderManager;
import model.Supplier;
import model.SupplierManager;
import model.InventoryManager;
import model.Customer;
import model.CustomerOrder;
import model.CustomerOrderManager;

class Main {
    
    private static SupplierManager supplierManager = new SupplierManager();
    private static PurchaseOrderManager purchaseOrderManager = new PurchaseOrderManager();
    private static CustomerOrderManager customerOrderManager = new CustomerOrderManager();


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
        InventoryManager.inventoryManager.addProduct(product1);
        InventoryManager.inventoryManager.addProduct(product2); 
        InventoryManager.inventoryManager.addProduct(product3);
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
            System.out.println("8. Update Supplier");
            System.out.println("9. Create Purchase Order"); 
            System.out.println("10. Receive Delivery"); 
            System.out.println("11. Create a customer order");
            System.out.println("12. View all customer orders");
            System.out.println("13. View all purchase orders");
            System.out.println("14. Send customer order");

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
                case 10 -> receiveDelivery(scanner); // Receive delivery from a supplier
                case 11 -> createCustomerOrder(scanner);
                case 12 -> viewAllCustomerOrders(scanner); // view all customer orders in memory
                case 13 -> viewAllPurchaseOrders(scanner); // View details of a specific customer order
                case 14 -> sendCustomerOrder(scanner); // Send customer order
                case 0 -> System.out.println("Exiting the system. Goodbye!");
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
        if (InventoryManager.inventoryManager.addProduct(product)) {
            System.out.println("Product added: " + product.getName());
        } else {
            System.out.println("Failed to add product. Inventory might be full. Please try again.");
        }
    } 
    
    // Method to restock a product for case 2
    private static void restockProduct(Scanner scanner) {
       // if (inventoryManager.isInventoryEmpty()) {
      //      System.out.println("Sorry, there are no products in the system. Please add a product first.");
       //     return;
      //  }

        System.out.println("Current Inventory:");
        InventoryManager.inventoryManager.printInventory();
        
        System.out.print("Enter the ID of the product you want to restock: ");
        int productId = scanner.nextInt();
        System.out.print("Enter the quantity to add: ");
        int quantity = scanner.nextInt();

        InventoryManager.inventoryManager.restockProduct(productId, quantity);
    }

     // Method to print the inventory for case 3
    private static void viewInventory(Scanner scanner) {
        if (InventoryManager.inventoryManager.isInventoryEmpty()) {
            System.out.println("Sorry, there are no products in the system. Please add a product first.");
            return;
        }
        System.out.println("Current Inventory:");
        InventoryManager.inventoryManager.printInventory();
      
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
    System.out.print("Enter Supplier ID: ");
    int supplierId = scanner.nextInt();
    scanner.nextLine();

    List<PurchaseOrder.POItem> items = new ArrayList<>();
    String addMore;
    do {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Unit Cost: ");
        double unitCost = scanner.nextDouble();
        scanner.nextLine();

        items.add(new PurchaseOrder.POItem(productId, quantity, unitCost));

        System.out.print("Add another item? (yes/no): ");
        addMore = scanner.nextLine();
    } while (addMore.equalsIgnoreCase("yes"));

    // Case 9 - Create a new PurchaseOrder object and set its properties 
    PurchaseOrder po = new PurchaseOrder();
    po.setOrderId(/* generate or prompt for order ID */ 1); // You may want to auto-increment or prompt
    po.setSupplierId(supplierId);
    po.setOrderDate(java.time.LocalDateTime.now());
    po.setDeliveryStatus("Pending");
    po.setTotalPrice(items.stream().mapToDouble(i -> i.getQuantity() * i.getUnitCost()).sum());
    po.setOrderList(items); 
    // po.setOrderList(items); // You may need to add this setter in PurchaseOrder

    purchaseOrderManager.addPurchaseOrder(po); 
    System.out.println("Purchase order created:\n" + po);
}

    public static void receiveDelivery(Scanner scanner) {  
        System.out.println("Receiving delivery from supplier (not implemented yet).");
        System.out.println("Enter Order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();
       
        purchaseOrderManager.receiveDelivery(orderId); 

}

// Method to create a customer order for case 11
private static void createCustomerOrder(Scanner scanner) {
        
    System.out.println("Creating a customer order:");
    List<CustomerOrder.COItem> items = new ArrayList<>();
    String addMore;
    do {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        items.add(new CustomerOrder.COItem(productId, quantity, 0));

        System.out.print("Add another item? (yes/no): ");
        scanner.nextLine(); // Consume newline
        addMore = scanner.nextLine();
    } while (addMore.equalsIgnoreCase("yes"));
    
    CustomerOrder po = new CustomerOrder();
    po.setOrderId(/* generate or prompt for order ID */ 1); // You may want to auto-increment or prompt
    po.setOrderDate(java.time.LocalDateTime.now());
    po.setOrderList(items);
    po.setTotalPrice(items.stream().mapToDouble(i -> i.getQuantity() * i.getUnitPrice()).sum());
    po.setStatus("Pending"); 
    
    customerOrderManager.addCustomerOrder(po);

    System.out.println("Customer order created successfully.");
}


// Method to view all customer orders for case 12
private static void viewAllCustomerOrders(Scanner scanner) {
    List<CustomerOrder> customerOrders = customerOrderManager.getAllCustomerOrders();
    if (customerOrders.isEmpty()) {
        System.out.println("No customer orders found.");
    } else {
        System.out.println("Customer Orders:");
        for (CustomerOrder order : customerOrders) {
            System.out.println(order);
        }
    }
}

    // Method to view all purchase orders for case 13
    private static void viewAllPurchaseOrders(Scanner scanner) {
        System.out.println("Viewing all purchase orders (not implemented yet).");


        List<PurchaseOrder> purchaseOrders = purchaseOrderManager.getAllPurchaseOrders();
        if (purchaseOrders.isEmpty()) {
            System.out.println("No purchase orders found.");
        } else {
            System.out.println("Purchase Orders:");
            for (PurchaseOrder order : purchaseOrders) {
                System.out.println(order);
            }
        }
    }


    // Method to send a customer order for case 14
    private static void sendCustomerOrder(Scanner scanner) {
        System.out.println("Sending customer order");
        System.out.print("Enter Customer Order ID to send: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();

        customerOrderManager.processCustomerOrder(orderId);
    }
}
