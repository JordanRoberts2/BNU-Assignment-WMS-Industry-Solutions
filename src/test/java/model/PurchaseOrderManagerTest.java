package src.test.java.model;
import model.InventoryManager;
import model.PurchaseOrder;
import model.PurchaseOrderManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;
public class PurchaseOrderManagerTest {

    static class MockInventoryManager extends InventoryManager {
        private int lastProductId = -1;
        private int lastQuantity = -1;

        @Override
        public void restockProduct(int productId, int quantity) {
            this.lastProductId = productId;
            this.lastQuantity = quantity;
        }
 
        public int getLastProductId() {
            return lastProductId;
        }
 
        public int getLastQuantity() {
            return lastQuantity;
        }
    }
 
    private MockInventoryManager mockInventory;

    //
    private PurchaseOrderManager purchaseOrderManager;
    private PurchaseOrder purchaseOrder;

    @Before public void setUp() {
        mockInventory = new MockInventory();
        purchaseOrderManager = new PurchaseOrderManager();

        purchaseOrder = new PurchaseOrder();
        purchaseOrder.setOrderId(1);
        purchaseOrder.setSupplierId(101);
        purchaseOrder.setTotalPrice(150.0);
        purchaseOrder.setDeliveryStatus("Pending");
        purchaseOrderManager.addPurchaseOrder(purchaseOrder);
    }

    @Test public void testAddPurchaseOrder() {
        Assertions.assertEquals(1, purchaseOrderManager.getAllPurchaseOrders().size());
    }
    
@Test public void testReceiveDelivery() {
        purchaseOrderManager.receiveDelivery(1);
        Assertions.assertEquals("Delivered", purchaseOrder.getDeliveryStatus());
    }

    @Test public void testReceiveDeliveryInvalidId() {
        purchaseOrderManager.receiveDelivery(999);
        // Should print "Purchase Order 999 not found." 
        }

   @Test public void testRestockProduct() {
        purchaseOrderManager.receiveDelivery(1);
        Assertions.assertEquals(10, mockInventory.getLastProductId());
        Assertions.assertEquals(5, mockInventory.getLastQuantity());
   }
}