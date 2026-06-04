package com.example.hexagonal.config;

import com.example.hexagonal.application.port.in.PlaceOrderUseCase;
import com.example.hexagonal.application.port.out.OrderRepository;
import com.example.hexagonal.application.service.PlaceOrderService;
import com.example.hexagonal.domain.service.OrderPricingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    public OrderPricingService orderPricingService() {
        return new OrderPricingService();
    }

    @Bean
    public PlaceOrderUseCase placeOrderUseCase(OrderRepository orderRepository,
                                               OrderPricingService orderPricingService) {
        return new PlaceOrderService(orderRepository, orderPricingService);
    }
}

