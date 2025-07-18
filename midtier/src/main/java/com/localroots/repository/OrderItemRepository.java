package com.localroots.repository;

import com.localroots.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrder_OrderId(Long orderId);
    List<OrderItem> findByProduct_ProductId(Long productId);
}
