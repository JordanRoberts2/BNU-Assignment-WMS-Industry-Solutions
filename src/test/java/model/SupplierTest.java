package model;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class SupplierTest {

    @After
    public void tearDown() {
        Supplier.clearID();
    }
    @Test
    public void testSupplierCreationAndGetters() {
        Supplier supplier = new Supplier("John Doe", "John.gmail.com");
        assertEquals(1, supplier.getId());
        assertEquals("John Doe", supplier.getName());
        assertEquals("John.gmail.com", supplier.getContact());
    }

    @Test
    public void testSupplierSetters() {
        Supplier supplier = new Supplier("John Doe", "John.gmail.com");
        supplier.setId(2);
        supplier.setName("Jane Doe");
        supplier.setContact("Jane.gmail.com");

        assertEquals(2, supplier.getId());
        assertEquals("Jane Doe", supplier.getName());
        assertEquals("Jane.gmail.com", supplier.getContact());
    }

    @Test
    public void testNoNegativeId() {
        Supplier supplier = new Supplier("Invalid", "invalid.gmail.com");
        assertTrue(supplier.getId() >= 0); // Assuming ID should not be negative
    }
}

