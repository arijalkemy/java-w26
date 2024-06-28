package com.mercadolibre.project_be_java_hisp_w26_t7.repository;

import com.mercadolibre.project_be_java_hisp_w26_t7.entity.Buyer;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository  extends JpaRepository<Order, Long> {
    Boolean existsByBuyerId(Long buyer_id);
}
