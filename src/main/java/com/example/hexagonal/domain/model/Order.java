package com.example.hexagonal.domain.model;

import java.util.List;

public class Order {

    private Long id;
    private final Long customerId;
    private final List<OrderItem> items;
    private double total;

    public Order(Long id, Long customerId, List<OrderItem> items, double total) {
        if (customerId == null) {
            throw new IllegalArgumentException("customerId must not be null");
        }
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("order must contain at least one item");
        }

        this.id = id;
        this.customerId = customerId;
        this.items = items;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public void assignTotal(double total) {
        this.total = total;
    }
}
