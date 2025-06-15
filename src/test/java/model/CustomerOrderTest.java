package src.test.java.model;

public class CustomerOrderTest {
    
    private CustomerOrder order;
    private List<COItem> itemList;

    @Before
    public void setUp() {
        itemList = new ArrayList<>();
        itemList.add(new COItem(101, 2, 50.0));
        itemList.add(new COItem(102, 1, 100.0));

        order = new CustomerOrder();
        order.setOrderId(1);
        order.setOrderDate(LocalDateTime.now());
        order.setOrderList(itemList);
        order.setTotalPrice(200.0);
        order.setStatus("Pending");
    }
    @Test public void testOrderCreation() {
        assertNotNull(order);
        assertEquals(1, order.getOrderId());
        assertNotNull(order.getOrderDate());
        assertEquals(2, order.getOrderList().size());
        assertEquals(200.0, order.getTotalPrice(), 0.01);
        assertEquals("Pending", order.getStatus());
    }
    @Test public void testCOItemCreationAndGetters() {
        COItem item = new COItem(101, 2, 50.0);
        assertEquals(101, item.getProductId());
        assertEquals(2, item.getQuantity());
        assertEquals(50.0, item.getUnitPrice(), 0.01);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCOItemCreationWithNegativeProductId() {
        new COItem(-1, 2, 50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCOItemCreationWithZeroQuantity() {
        new COItem(101, 0, 50.0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCOItemCreationWithNegativeUnitPrice() {
        new COItem(101, 2, -50.0);
    }

    @Test public void testSetValidStatus() {
        order.setStatus("Delivered");
        assertEquals("Delivered", order.getStatus());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidStatus() {
        order.setStatus("In Progress");
    }
}
