package model;
import java.util.ArrayList;
public class SupplierManager {

    private ArrayList<Supplier> supplierList = new ArrayList<>();

    //add supplier function
    public boolean addSupplier(Supplier supplier) {
        supplierList.add(supplier);
  return true;
    }

public Supplier getSupplier(String name) {
    for (Supplier supplier : supplierList) {
        if (supplier.getName().equalsIgnoreCase(name)) {
            return supplier;
        }
    }
    return null;
}

public void printSupplierInfo() {
    if (supplierList.isEmpty()) {
        System.out.println("The supplier list is currently empty. Please add a supplier first.");
    } else {
        for (Supplier supplier : supplierList) {
            System.out.println("ID: " + supplier.getId() + ", Name: " + supplier.getName() + ", Contact: " + supplier.getContact());

        }
    }
}

public Supplier deleteSupplier(int id) {
    for (Supplier supplier : supplierList) {
        if (supplier.getId() == id) {
            supplierList.remove(supplier);
            System.out.println("Supplier with ID " + id + " has been deleted.");
            return supplier; // Return the deleted supplier
        }
    }
    return null;
}
    // What if there are two suppliers with the same name? Supplier should be deleted by ID, not name. Ask user to specify ID if multiple suppliers have the same name?

    public Supplier updateSupplier(int id, String newName, String newContact) {
        for (Supplier supplier : supplierList) {
            if (supplier.getId() == id) {
                supplier.setName(newName);
                supplier.setContact(newContact);
                System.out.println("Supplier with ID " + id + " has been updated.");
                return supplier; // Return the updated supplier
            }
        }
        System.out.println("Supplier with ID " + id + " not found.");
        return null; // Return null if no supplier was found with the given ID

   /* public void printSupplierInfo() { //Print all suppliers in memory
        if (supplierCount == 0) {
            System.out.println("The supplier list is currently empty. Please add a supplier first.");
        } else {
            for (int i = 0; i < supplierCount; i++) {
                Supplier supplier = suppliers[i];
                System.out.println("ID: " + supplier.getId() + ", Name: " + supplier.getName() + ", Contact: " + supplier.getContact());
            }
        }
    } */  
//------END OF CLASS------------
//------END OF CLASS-------------
}
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