package com.example.hexagonal.adapter.in.rest;

public class PlaceOrderResponse {

    private final Long orderId;
    private final double total;

    public PlaceOrderResponse(Long orderId, double total) {
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
