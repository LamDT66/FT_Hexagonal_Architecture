package com.example.hexagonal.adapter.in.rest;

import java.util.List;

public class PlaceOrderRequest {

    private Long customerId;
    private List<PlaceOrderItemRequest> items;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<PlaceOrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<PlaceOrderItemRequest> items) {
        this.items = items;
    }
}
