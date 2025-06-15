package model;

public class POItem {
        private int productId;
        private int quantity;
        private double unitCost;
 
        public POItem(int productId, int quantity, double unitCost) {
            if (productId < 0) {
                throw new IllegalArgumentException("Invalid product ID.");
            }
            if (quantity <= 0) {
                throw new IllegalArgumentException("Please order at least one item.");
            }
            if (unitCost < 0) {
                throw new IllegalArgumentException("Unit cost cannot be negative for a purchase order item.");
            }
            this.productId = productId;
            this.quantity = quantity;
            this.unitCost = unitCost;
        }
 
        public int getProductId() { return productId; }
        public int getQuantity() { return quantity; }
        public double getUnitCost() { return unitCost; }
 
        @Override 
        public String toString() {
            return "POItem{" +
                   "productId='" + productId + '\'' +
                   ", quantity=" + quantity +
                   ", unitCost=" + String.format("%.2f", unitCost) +
                   '}';
        }
    }