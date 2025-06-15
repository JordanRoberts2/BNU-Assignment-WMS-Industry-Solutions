package model;

public class COItem {
        private int productId;
        private int quantity;
        private double unitPrice;

        public COItem(int productId, int quantity, double unitPrice) {
            if (productId < 0) {
                throw new IllegalArgumentException("Invalid product ID.");
            }
            if (quantity <= 0) {
                throw new IllegalArgumentException("Please order at least one item.");
            }
            if (unitPrice < 0) {
                throw new IllegalArgumentException("Unit price cannot be negative for a customer order item.");
            }
            this.productId = productId;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public int getProductId() { return productId; }
        public int getQuantity() { return quantity; }
        public double getUnitPrice() { return unitPrice; }

        @Override 
        public String toString() {
            return "COItem{" +
            "productId='" + productId + '\'' +
            ", quantity=" + quantity +
            ", unitPrice=" + String.format("%.2f", unitPrice) +
            '}';
        }
    }