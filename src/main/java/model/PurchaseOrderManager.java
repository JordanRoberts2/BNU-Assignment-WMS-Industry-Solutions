package model;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderManager {
    private List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    public void addPurchaseOrder(PurchaseOrder po) {
        purchaseOrders.add(po);
    }

    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrders;
    }

    public void receiveDelivery(int purchaseOrderId) {

        //find by purchaseorderId from list
        PurchaseOrder foundOrder = null;
        for (PurchaseOrder order : purchaseOrders) {
            if (order.getOrderId() == purchaseOrderId) {
                foundOrder = order;
                break;
            }
        }

        if (foundOrder != null) {
            foundOrder.setStatus("Delivered");
            System.out.println("Purchase Order " + purchaseOrderId + " has been marked as delivered.");
            for (POItem item : foundOrder.getItems()) {
                System.out.println("Restocking product ID: " + item.getProductId() + " with quantity: " + item.getQuantity());

                InventoryManager.inventoryManager.restockProduct(item.getProductId(), item.getQuantity());

            }
        } else {
            System.out.println("Purchase Order " + purchaseOrderId + " not found.");
        }

    }
}