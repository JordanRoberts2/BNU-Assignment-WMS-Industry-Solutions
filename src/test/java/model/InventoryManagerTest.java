package src.test.java.model;

public class InventoryManagerTest {
  private InventoryManager inventoryManager;
    private Product product1;
    private Product product2;
 
    @Before
    public void setUp() {
        inventoryManager = new InventoryManager();
        product1 = new Product("Product A", 1, 100, 10);
        product2 = new Product("Product B", 2, 150, 3);
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


    //private int productCount = 0;
    //add product function
    //public boolean addProduct(Product product) {
   //     productList.add(product);
     //   productCount++;
     //   return true;
 //   }


    //find product by id

    //restock produc


//decrease product

}
