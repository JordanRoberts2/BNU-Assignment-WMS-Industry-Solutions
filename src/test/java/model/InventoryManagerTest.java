package model;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryManagerTest {
    private InventoryManager inventoryManager;
    private Product product1;
    private Product product2;

    @Before
    public void setUp() {
        inventoryManager = new InventoryManager();
        product1 = new Product("Product A", 1,10);
        product2 = new Product("Product B", 2,3);
    }

    @After
    public void tearDown() {
        inventoryManager = null;
        product1 = null;
        product2 = null;
    }

    //add product
    @Test public void testAddProduct() {
    boolean result = inventoryManager.addProduct(product1);
        assertTrue(result);
        assertNotNull(inventoryManager.findProductById(1));
    }
    
    @Test public void testFindProductById() {
        inventoryManager.addProduct(product1);
        Product foundProduct = inventoryManager.findProductById(1);
        assertNotNull(foundProduct);
        assertEquals("Product A", foundProduct.getName());
    }

    @Test public void testIsInventoryEmpty() {
        assertTrue(inventoryManager.isInventoryEmpty());
        inventoryManager.addProduct(product1);
        assertFalse(inventoryManager.isInventoryEmpty());
    }

    @Test public void testRestockProduct() {
        inventoryManager.addProduct(product1);
        inventoryManager.restockProduct(1, 5);
        Product foundProduct = inventoryManager.findProductById(1);
        assertNotNull(foundProduct);
        assertEquals(15, foundProduct.getStockLevel());
    }

    @Test public void testDecreaseProduct() {
        inventoryManager.addProduct(product1);
        inventoryManager.decreaseProduct(1, 3);
        assertEquals (7, product1.getStockLevel());
    }

}
