package model;

public class SupplierManager {

 private Supplier[] suppliers = new Supplier[100];
    private int supplierCount = 0;
    //add supplier function
    public boolean addSupplier(Supplier supplier) {
        suppliers[supplierCount] = supplier;
        return true;
    }
}

//updateSupplier()

//deleteSupplier()

//-------getSupplier() - Show details for one supplier, by inputing the name value (e.g. 'Sony')
/*{
    DO THIS FOR HOMEWORK TO PRACTICE FOR LOOPS!
    public getSupplier;
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
}-------

//viewSuppliers() - like print inventory, prints a list of the suppliers in memory 
SIMILIAR TO ABOVE, PRINTS ALL SUPPLIRS
*/