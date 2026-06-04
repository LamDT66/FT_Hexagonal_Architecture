package com.example.hexagonal.application.dto;

import java.util.List;

public class PlaceOrderCommand {

    private final Long customerId;
    private final List<OrderItemCommand> items;

    public PlaceOrderCommand(Long customerId, List<OrderItemCommand> items) {
        this.customerId = customerId;
        this.items = items;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public List<OrderItemCommand> getItems() {
        return items;
    }

    public static class OrderItemCommand {
        private final String productCode;
        private final int quantity;
        private final double unitPrice;

        public OrderItemCommand(String productCode, int quantity, double unitPrice) {
            this.productCode = productCode;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public String getProductCode() {
            return productCode;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getUnitPrice() {
            return unitPrice;
        }
    }
}
