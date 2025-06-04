package model;
import java.util.ArrayList;
import java.util.List;

public class CustomerOrderManager {
    private List<CustomerOrder> customerOrders = new ArrayList<>();

    public void addCustomerOrder(CustomerOrder order) {
        customerOrders.add(order);
    }

    public List<CustomerOrder> getAllCustomerOrders() {
        return customerOrders;
    }

    public void processCustomerOrder(int customerOrderId) {
        CustomerOrder orderToProcess = null;
        for (CustomerOrder order : customerOrders) {
            if (order.getOrderId() == customerOrderId) {
                orderToProcess = order;
              
                //order.setTotalRevenue(order.calculateTotalRevenue());
                //System.out.println("Order " + customerOrderId + " has been processed.");
                break;
            }
        }
    if (orderToProcess != null) {
          orderToProcess.setStatus("Delivered");
            System.out.println("Order " + customerOrderId + " has been processed.");
            // For example, you might want to print the order details
            System.out.println("Order Details: " + orderToProcess);
        } else {
            System.out.println("Order with ID " + customerOrderId + " not found.");
        }
    
        for(CustomerOrder.COItem item : orderToProcess.getOrderList()) {
            // Assuming you have an InventoryManager instance to update the stock
            System.out.println("Updating inventory for product ID: " + item.getProductId() + " with quantity: " + item.getQuantity());
            
            // Update the inventory based on the order items
            InventoryManager.inventoryManager.decreaseProduct(item.getProductId(), item.getQuantity());
        }
    }


}