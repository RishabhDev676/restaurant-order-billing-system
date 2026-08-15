package com.restaurant;

import java.util.ArrayList;
import java.util.List;

public class BillingManager {
    public static class OrderItem {
        private final String name;
        private final int quantity;
        private final double unitPrice;

        public OrderItem(String name, int quantity, double unitPrice) {
            this.name = name;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public String getName() { return name; }
        public int getQuantity() { return quantity; }
        public double getUnitPrice() { return unitPrice; }
        public double getTotalPrice() { return quantity * unitPrice; }
    }

    private final List<OrderItem> currentOrder = new ArrayList<>();

    public void addItem(String name, int quantity, double unitPrice) {
        currentOrder.add(new OrderItem(name, quantity, unitPrice));
    }

    public List<OrderItem> getCurrentOrder() {
        return currentOrder;
    }

    public double calculateGrandTotal() {
        double total = 0;
        for (OrderItem item : currentOrder) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void reset() {
        currentOrder.clear();
    }

    public boolean isEmpty() {
        return currentOrder.isEmpty();
    }
}
