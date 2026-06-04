package com.example.hexagonal.domain.service;

import com.example.hexagonal.domain.model.Order;

public class OrderPricingService {

    public double calculateTotal(Order order) {
        return order.getItems()
                .stream()
                .mapToDouble(item -> item.subtotal())
                .sum();
    }
}

