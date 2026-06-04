package com.example.hexagonal.application.dto;

public class PlaceOrderResult {

    private final Long orderId;
    private final double total;

    public PlaceOrderResult(Long orderId, double total) {
        this.orderId = orderId;
        this.total = total;
    }

    public Long getOrderId() {
        return orderId;
    }

    public double getTotal() {
        return total;
    }
}
