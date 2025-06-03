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
}