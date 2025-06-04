package model;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class CustomerOrder {
    private int orderId;
    private LocalDateTime orderDate;
    private List<COItem> orderList;
    private double totalRevenue;
    private String status;

    /*public CustomerOrder(int orderId, LocalDateTime orderDate, List<COItem> orderList, double totalRevenue, String status) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderList = orderList;
        this.totalRevenue = calculateTotalRevenue();
        this.status = status; */
    
    
    public static class COItem {
        private int productId;
        private int quantity;
        private double unitPrice;

        public COItem(int productId, int quantity, double unitPrice) {
            if (productId < 0) {
                throw new IllegalArgumentException("Invalid product ID.");
            }
            if (quantity <= 0) {
                throw new IllegalArgumentException("Please order at least one item.");
            }
            if (unitPrice < 0) {
                throw new IllegalArgumentException("Unit price cannot be negative for a customer order item.");
            }
            this.productId = productId;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public int getProductId() { return productId; }
        public int getQuantity() { return quantity; }
        public double getUnitPrice() { return unitPrice; }

        @Override 
        public String toString() {
            return "COItem{" +
                   "productId='" + productId + '\'' +
                   ", quantity=" + quantity +
                   ", unitPrice=" + String.format("%.2f", unitPrice) +
                   '}';
        }
    }

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    public List<COItem> getOrderList() {
        return orderList;
    }
    public void setOrderList(List<COItem> orderList) {
        this.orderList = orderList;
    }
    public double getTotalPrice() {
        return totalRevenue;
    }
    public void setTotalPrice(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
    
    /*private double calculateTotalRevenue() {
        return orderList.stream()
                    .mapToDouble(item -> item.getQuantity() * item.getUnitPrice())
                    .sum();
    }*/
 
    //CO Item

    public void setStatus(String newStatus) {
        if (!isValidStatus(newStatus)) {
            throw new IllegalArgumentException("Invalid status. Must be one of 'Pending', 'Delivered', 'Cancelled'.");
        }
        this.status = newStatus;
        System.out.println("Customer Order " + this.orderId + " status updated to " + this.status);
    }

    private boolean isValidStatus(String status) {
        return Objects.equals(status, "Pending") ||
               Objects.equals(status, "Delivered") ||
               Objects.equals(status, "Cancelled");
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
               "orderId='" + orderId + '\'' +
               ", orderDate=" + orderDate +
               ", orderList=" + orderList +
               ", status='" + status + '\'' +
               ", totalRevenue=" + String.format("%.2f", totalRevenue) +
               '}';
    }

    //Process customer order
    
}