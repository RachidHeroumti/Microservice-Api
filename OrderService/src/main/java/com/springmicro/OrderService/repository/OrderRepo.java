package com.springmicro.OrderService.repository;

import com.springmicro.OrderService.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
