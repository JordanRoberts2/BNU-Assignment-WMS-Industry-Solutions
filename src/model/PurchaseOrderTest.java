package src.test.java.model;
import model.PurchaseOrder;
import model.PurchaseOrder.POItem;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

public class PurchaseOrderTest {
  
        private PurchaseOrder purchaseOrder;
        private List<POItem> itemList;

        @Before
        public void setUp() {
            itemList = new ArrayList<>();
            itemList.add(new POItem(201, 5, 20.0));
            itemList.add(new POItem(202, 3, 30.0));

            purchaseOrder = new PurchaseOrder();
            purchaseOrder.setOrderId(1);
            purchaseOrder.setSupplierId(101);
            purchaseOrder.setOrderDate(LocalDateTime.now());
            purchaseOrder.setOrderList(itemList);
            purchaseOrder.setTotalPrice(150.0);
            purchaseOrder.setDeliveryStatus("Pending");
        }

        @Test public void testPurchaseOrderCreation() {
            assertNotNull(purchaseOrder);
            assertEquals(1, purchaseOrder.getOrderId());
            assertEquals(101, purchaseOrder.getSupplierId());
            assertNotNull(purchaseOrder.getOrderDate());
            assertEquals(2, purchaseOrder.getItems().size());
            assertEquals(150.0, purchaseOrder.getTotalPrice(), 0.01);
            assertEquals("Pending", purchaseOrder.getDeliveryStatus());
        }

        @Test public void testPOItemCreationAndGetters() {
            POItem item = new POItem(201, 5, 20.0);
            assertEquals(201, item.getProductId());
            assertEquals(5, item.getQuantity());
            assertEquals(20.0, item.getUnitCost(), 0.01);
        }

        @Test(expected = IllegalArgumentException.class)
        public void testPOItemCreationWithNegativeProductId() {
            new POItem(-1, 5, 20.0);
        }
       
        @Test(expected = IllegalArgumentException.class)
        public void testPOItemCreationWithZeroQuantity() {
            new POItem(201, 0, 20.0);
        }
        @Test(expected = IllegalArgumentException.class)
        public void testPOItemCreationWithNegativeUnitCost() {
            new POItem(201, 5, -20.0);
        }
        @Test public void testSetValidDeliveryStatus() {
            purchaseOrder.setDeliveryStatus("Cancelled");
            assertEquals("Delivered", purchaseOrder.getDeliveryStatus());
        }

        @Test(expected = IllegalArgumentException.class)
        public void testSetInvalidDeliveryStatus() {
            purchaseOrder.setDeliveryStatus("In Transit");
        }

        @Test
        public void testTotalPriceMatchesExpected() {
             double expectedTotal = (item1.getQuantity() * item1.getUnitCost()) +
             (item2.getQuantity() * item2.getUnitCost());
             Assertions.assertEquals(expectedTotal, order.getTotalPrice());
    }
}

