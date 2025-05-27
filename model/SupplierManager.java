package model;
import java.util.ArrayList;
public class SupplierManager {

 private Supplier[] suppliers = new Supplier[100];
    private int supplierCount = 0;
    //add supplier function
    public boolean addSupplier(Supplier supplier) {
        suppliers[supplierCount] = supplier;
        return true;
    }


//updateSupplier()



//deleteSupplier()

//-------getSupplier() - Show details for one supplier, by inputing the name value (e.g. 'Sony')
    // This method retrieves a supplier by name, returning null if not found
    public Supplier getSupplier(String name) {
        for (int i = 0; i < supplierCount; i++) {
            if (suppliers[i].getName().equalsIgnoreCase(name)) {
                return suppliers[i];
            }
        }
        return null; // Return null if no supplier found
    }

    public void printSupplierInfo() { //Print all suppliers in memory
        if (supplierCount == 0) {
            System.out.println("The supplier list is currently empty. Please add a supplier first.");
        } else {
            for (int i = 0; i < supplierCount; i++) {
                Supplier supplier = suppliers[i];
                System.out.println("ID: " + supplier.getId() + ", Name: " + supplier.getName() + ", Contact: " + supplier.getContact());
            }
        }
    }
//------END OF CLASS------------
//------END OF CLASS-------------
}
    
    /*public getSupplier;
public void printInventory() {
        if (productCount == 0) {
            System.out.println("The inventory is currently empty. Please add a product first.");
        } else {
            for (int i = 0; i < productCount; i++) {
                Product product = products[i];
                System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Stock: " + product.getStockLevel() + ", Price: " + product.getPrice());
            }
        }
    }
}

//viewSuppliers() - like print inventory, prints a list of the suppliers in memory 
//SIMILIAR TO ABOVE, PRINTS ALL SUPPLIRS
*/