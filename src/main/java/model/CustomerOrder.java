package model;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class CustomerOrder {
    private static int nextOrderId = 1;
    private int orderId;
    private LocalDateTime orderDate;
    private List<COItem> orderList;
    private double totalRevenue;
    private String status;

    public CustomerOrder(){

    }
public CustomerOrder(LocalDateTime orderDate, List<COItem> orderList, double totalRevenue, String status) {
        this.orderId = nextOrderId++;
        this.orderDate = orderDate;
        this.orderList = orderList;
        this.totalRevenue = totalRevenue;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

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