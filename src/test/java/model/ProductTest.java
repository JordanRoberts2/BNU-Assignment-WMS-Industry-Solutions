package src.test.java.model;
import src.model;
import org.junit.Test;
import static org.junit.Assert.*;
import java.beans.Transient;

public class ProductTest {
    @Test
    public void testProductCreationAndGetters() {
        Product product = new Product(1, "Laptop", "High-end gaming laptop", 1500.00, 10);
        assertEquals(1, product.getId());
        assertEquals("Laptop", product.getName());
        assertEquals("High-end gaming laptop", product.getDescription());
        assertEquals(1500.00, product.getPrice(), 0.01);
        assertEquals(10, product.getStock());}

    @Test
    public void testProductSetters() {
        Product product = new Product(1, "Laptop", "High-end gaming laptop", 1500.00, 10);
        product.setId(2);
        product.setName("Desktop");
        product.setDescription("Powerful desktop computer");
        product.setPrice(1200.00);
        product.setStock(5);

        assertEquals(2, product.getId( ));
        assertEquals("Desktop", product.getName());
        assertEquals("Powerful desktop computer", product.getDescription());
        assertEquals(1200.00, product.getPrice(), 0.01);
        assertEquals(5, product.getStock());
    }

    @Test
    public void testAddStock() {
        Product product = new Product("1", "Laptop", "High-end gaming laptop", 1500.00, 10);
        product.addStock(5);
        assertEquals(15, product.getStock());
    }

    @test
    public void testAddNegativeStock() {
        Product product = new Product(1, "Laptop", "High-end gaming laptop", 1500.00, 10);
        product.addStock(-5);
        assertEquals(10, product.getStock()); // Stock should remain unchanged
    }
}
