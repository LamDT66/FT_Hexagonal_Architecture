package com.example.hexagonal.application.port.in;

import com.example.hexagonal.application.dto.PlaceOrderCommand;
import com.example.hexagonal.application.dto.PlaceOrderResult;

public interface PlaceOrderUseCase {
    PlaceOrderResult placeOrder(PlaceOrderCommand command);
}

