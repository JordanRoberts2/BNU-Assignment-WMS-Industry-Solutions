package model;

public class Order {
    private String orderId;
    private String items;
    private String customerId;
    private double totalPrice;

    public Order(String orderId, String items, String customerId, double totalPrice) {
        this.orderId = orderId;
        this.items = items;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
    }

     // Getters and setters
     public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getItems() {
        return items;
    }
    public void setItems(String items) {
        this.items = items;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // Print order details
    public void printOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Items: " + items);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Total Price: " + totalPrice);
    }
}
