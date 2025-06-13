package src.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PurchaseOrder {
    
    public static class POItem {
        private int productId;
        private int quantity;
        private double unitCost;
 
        public POItem(int productId, int quantity, double unitCost) {
            if (productId < 0) {
                throw new IllegalArgumentException("Invalid product ID.");
            }
            if (quantity <= 0) {
                throw new IllegalArgumentException("Please order at least one item.");
            }
            if (unitCost < 0) {
                throw new IllegalArgumentException("Unit cost cannot be negative for a purchase order item.");
            }
            this.productId = productId;
            this.quantity = quantity;
            this.unitCost = unitCost;
        }
 
        public int getProductId() { return productId; }
        public int getQuantity() { return quantity; }
        public double getUnitCost() { return unitCost; }
 
        @Override 
        public String toString() {
            return "POItem{" +
                   "productId='" + productId + '\'' +
                   ", quantity=" + quantity +
                   ", unitCost=" + String.format("%.2f", unitCost) +
                   '}';
        }
    }
    // Purchase Order attributes
        private static int nextPurchaseOrderId = 1;    
        private int orderId;
        private int supplierId;
        private LocalDateTime orderDate;
        private String deliveryStatus;
        private double totalPrice;
        private List<POItem> orderList;
        
        public PurchaseOrder(int supplierId, LocalDateTime orderDate, String deliveryStatus, double totalPrice, List<POItem> orderList) { // Removed orderId from constructor parameters
        this.orderId = nextPurchaseOrderId++; // Auto-increment and assign ID
        this.supplierId = supplierId;
        this.orderDate = orderDate;
        this.deliveryStatus = deliveryStatus;
        this.totalPrice = totalPrice;
        this.orderList = orderList;
    }
    
     // Getters and setters
     public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }
    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;


    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public List<POItem> getItems() {
        return orderList;
    }

    public void setStatus(String newStatus) {
        if (!isValidStatus(newStatus)) {
            throw new IllegalArgumentException("Invalid status. Must be one of 'Pending', 'Delivered', 'Cancelled'.");
        }
        this.deliveryStatus = newStatus;
        System.out.println("Purchase Order " + this.orderId + " status updated to " + this.deliveryStatus);
    }

private boolean isValidStatus(String status) {
        return Objects.equals(status, "Pending") ||
               Objects.equals(status, "Delivered") ||
               Objects.equals(status, "Cancelled");
    }

    /**
     * Calculates the total cost of all items in the purchase order.
     *
     * @return The total cost.
     */
    private double calculateTotalCost() {
        return orderList.stream()
                    .mapToDouble(item -> item.getQuantity() * item.getUnitCost())
                    .sum();
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
               "orderId='" + orderId + '\'' +
               ", supplierId='" + supplierId + '\'' +
               ", orderDate=" + orderDate +
               ", items=" + orderList +
               ", status='" + deliveryStatus + '\'' +
               ", totalCost=" + String.format("%.2f", totalPrice) +
               '}';
    }

        public void setOrderList(List<POItem> items) {
        this.orderList = items;
    }
  
    public  void receiveDelivery(Scanner scanner) {
       System.out.println("Please enter the order ID to receive delivery:");
        
    }
    
    /*  Print order details
    public void printOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Items: " + items);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Total Price: " + totalPrice);
    }*/
}