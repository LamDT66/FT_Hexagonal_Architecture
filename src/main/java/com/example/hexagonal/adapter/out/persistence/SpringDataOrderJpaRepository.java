package com.example.hexagonal.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataOrderJpaRepository extends JpaRepository<OrderJpaEntity, Long> {
}
