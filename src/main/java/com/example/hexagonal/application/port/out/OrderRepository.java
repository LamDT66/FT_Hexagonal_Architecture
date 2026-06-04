package com.example.hexagonal.application.port.out;

import com.example.hexagonal.domain.model.Order;

public interface OrderRepository {
    Order save(Order order);
}
