package com.example.hexagonal.adapter.in.rest;

import com.example.hexagonal.application.dto.PlaceOrderCommand;
import com.example.hexagonal.application.dto.PlaceOrderResult;
import com.example.hexagonal.application.port.in.PlaceOrderUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final PlaceOrderUseCase placeOrderUseCase;

    public OrderController(PlaceOrderUseCase placeOrderUseCase) {
        this.placeOrderUseCase = placeOrderUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlaceOrderResponse placeOrder(@RequestBody PlaceOrderRequest request) {

        PlaceOrderCommand command = new PlaceOrderCommand(
                request.getCustomerId(),
                request.getItems().stream()
                        .map(item -> new PlaceOrderCommand.OrderItemCommand(
                                item.getProductCode(),
                                item.getQuantity(),
                                item.getUnitPrice()
                        ))
                        .toList()
        );

        PlaceOrderResult result = placeOrderUseCase.placeOrder(command);

        return new PlaceOrderResponse(result.getOrderId(), result.getTotal());
    }
}
