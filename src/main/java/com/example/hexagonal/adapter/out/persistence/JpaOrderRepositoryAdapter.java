package com.example.hexagonal.adapter.out.persistence;

import com.example.hexagonal.application.port.out.OrderRepository;
import com.example.hexagonal.domain.model.Order;
import com.example.hexagonal.domain.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class JpaOrderRepositoryAdapter implements OrderRepository {

    private final SpringDataOrderJpaRepository springDataOrderJpaRepository;

    public JpaOrderRepositoryAdapter(SpringDataOrderJpaRepository springDataOrderJpaRepository) {
        this.springDataOrderJpaRepository = springDataOrderJpaRepository;
    }

    @Override
    public Order save(Order order) {
        OrderJpaEntity entity = toEntity(order);

        OrderJpaEntity savedEntity = springDataOrderJpaRepository.save(entity);

        return toDomain(savedEntity);
    }

    private OrderJpaEntity toEntity(Order order) {
        OrderJpaEntity entity = new OrderJpaEntity();
        entity.setCustomerId(order.getCustomerId());
        entity.setTotal(order.getTotal());

        for (OrderItem item : order.getItems()) {
            OrderItemJpaEntity itemEntity = new OrderItemJpaEntity();
            itemEntity.setProductCode(item.getProductCode());
            itemEntity.setQuantity(item.getQuantity());
            itemEntity.setUnitPrice(item.getUnitPrice());
            entity.addItem(itemEntity);
        }

        return entity;
    }

    private Order toDomain(OrderJpaEntity entity) {
        return new Order(
                entity.getId(),
                entity.getCustomerId(),
                entity.getItems().stream()
                        .map(itemEntity -> new OrderItem(
                                itemEntity.getProductCode(),
                                itemEntity.getQuantity(),
                                itemEntity.getUnitPrice()
                        ))
                        .toList(),
                entity.getTotal()
        );
    }
}
