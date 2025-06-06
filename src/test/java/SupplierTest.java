import src.model;
import org.junit.Test;
import static org.junit.Assert.*;
import java.beans.Transient;

public class SupplierTest {
    @Test
    public void testSupplierCreationAndGetters() {
        Supplier supplier = new Supplier(1, "John Doe", "John.gmail.com");
        assertEquals(1, supplier.getId());
        assertEquals("John Doe", supplier.getName());
        assertEquals("John.gmail.com", supplier.getContact());
    }

    @Test
    public void testSupplierSetters() {
        Supplier supplier = new Supplier(1, "John Doe", "John.gmail.com");
        supplier.setId(2);
        supplier.setName("Jane Doe");
        supplier.setContact("Jane.gmail.com");

        assertEquals(2, supplier.getId());
        assertEquals("Jane Doe", supplier.getName());
        assertEquals("Jane.gmail.com", supplier.getContact());
    }

    @Test
    public void testNoNegativeId() {
        Supplier supplier = new Supplier(-1, "Invalid", "invalid.gmail.com");
        assertFalse(supplier.getId() >= 0); // Assuming ID should not be negative
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSupplierCreationNegativeId() {
        new Supplier(-1, "Name", "contact");
    }
}

