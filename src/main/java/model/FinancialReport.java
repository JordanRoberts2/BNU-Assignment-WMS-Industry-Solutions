package model;

import java.util.List;

public class FinancialReport {
    private final List<PurchaseOrder> purchaseOrders;
    private final List<CustomerOrder> customerOrders;

    public FinancialReport(List<PurchaseOrder> purchaseOrders, List<CustomerOrder> customerOrders) {
        this.purchaseOrders = purchaseOrders;
        this.customerOrders = customerOrders;
    }

    public double getTotalPurchaseAmount() {
        return purchaseOrders.stream()
            .mapToDouble(PurchaseOrder::getTotalPrice)
            .sum();
    }

    public double getTotalSalesRevenue() {
        return customerOrders.stream()
            .mapToDouble(CustomerOrder::getTotalPrice)
            .sum();
    }

    public double getNetIncome() {
        return getTotalSalesRevenue() - getTotalPurchaseAmount();
    }

    public void printReport() {
        System.out.println("\n------ Financial Report ------");
        System.out.printf("Here is the total amount of stock bought from suppliers: £%.2f%n", getTotalPurchaseAmount());
        System.out.printf("Here is the total sales revenue:                         £%.2f%n", getTotalSalesRevenue());
        System.out.printf("Final balance for the BNU WMS (Net Income, Profit/Loss): £%.2f%n", getNetIncome());
        System.out.println("------------------------------\n");
    }
}