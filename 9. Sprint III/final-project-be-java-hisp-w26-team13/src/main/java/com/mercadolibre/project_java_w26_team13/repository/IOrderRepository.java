package com.mercadolibre.project_java_w26_team13.repository;

import com.mercadolibre.project_java_w26_team13.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
     Order save(Order order);

    Order findInboundOrderByOrderNumber(int orderNumber);

    Order findByOrderNumber(int orderNumber);
}
