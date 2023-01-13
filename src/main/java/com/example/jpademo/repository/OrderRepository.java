package com.example.jpademo.repository;

import com.example.jpademo.repository.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
