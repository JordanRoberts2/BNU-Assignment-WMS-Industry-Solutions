package model;
import org.junit.Test;
import static org.junit.Assert.*;


public class ProductTest {

    @Test public void testProductCreationAndGetters() {
        Product product = new Product( "Laptop", 160, 10);
        assertEquals("Laptop", product.getName());
        assertEquals(160, product.getPrice(), 0.01);
        assertEquals(10, product.getStockLevel());}

    @Test
    public void testProductSetters() {
        Product product = new Product("Laptop", 200, 10);
        product.setId(2);
        product.setName("Desktop");
        product.setPrice(1200);
        product.setStockLevel(5);

        assertEquals(2, product.getId( ));
        assertEquals("Desktop", product.getName());
        assertEquals(1200.00, product.getPrice(), 0.01);
        assertEquals(5, product.getStockLevel());
    }

    @Test
    public void testAddStock() {
        Product product = new Product("Laptop", 200, 10);
        product.addStock(5);
        assertEquals(15, product.getStockLevel());
    }

    @Test
    public void testAddNegativeStock() {
        Product product = new Product( "Laptop", 200, 10);
        product.addStock(-5);
        assertEquals(10, product.getStockLevel()); // Stock should remain unchanged
    }
}
