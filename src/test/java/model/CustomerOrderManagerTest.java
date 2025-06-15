package model;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

public class CustomerOrderManagerTest {
    
    private CustomerOrderManager customerOrderManager;
    private CustomerOrder order1;

    @Before public void setUp() {
        customerOrderManager = new CustomerOrderManager();
        order1 = new CustomerOrder();
        order1.setOrderId(1);
        order1.setStatus("Pending");
        order1.setTotalPrice(100.0);
        order1.setOrderDate(LocalDateTime.now());
        
        COItem item1 = new COItem(101, 2, 50.0);
        COItem item2 = new COItem(102, 1, 50.0);
        
        List<COItem> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        
        order1.setOrderList(itemList);
        Product product1 = new Product ("Product A", 101,  10);
        Product product2 = new Product ("Product B", 102, 5);
        InventoryManager.inventoryManager.addProduct(product1);
        InventoryManager.inventoryManager.addProduct(product2);
        customerOrderManager.addCustomerOrder(order1);
    }

    @Test public void testAddCustomerOrder() {
        List<CustomerOrder> orders = customerOrderManager.getAllCustomerOrders();
        assertEquals(1, orders.size());
        assertEquals(1, orders.get(0).getOrderId());
    }

    @Test public void testProcessCustomerOrderValidId() {
        customerOrderManager.processCustomerOrder(1);
        assertEquals("Delivered", order1.getStatus());

        Product product1 = InventoryManager.inventoryManager.findProductById(101);
        Product product2 = InventoryManager.inventoryManager.findProductById(102);
        assertEquals(8, product1.getStockLevel());
        assertEquals(4, product2.getStockLevel());
    }

    @Test public void testProcessCustomerOrderInvalidId() {
        customerOrderManager.processCustomerOrder(999);
        assertEquals("Pending", order1.getStatus());
        // Should print "Order with ID 999 not found."
        // No exception is expected, just a message
    }


}
