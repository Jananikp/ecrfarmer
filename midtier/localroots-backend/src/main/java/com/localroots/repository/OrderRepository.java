package com.localroots.repository;

import com.localroots.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByBuyer_UserId(Long userId);
    List<Order> findByStatus(String status);
    List<Order> findByPaymentStatus(String paymentStatus);
}
