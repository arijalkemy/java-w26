package com.mercadolibre.meli_frescos.repository;

import com.mercadolibre.meli_frescos.model.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInboundOrderRepository extends JpaRepository<InboundOrder,Integer> {
    InboundOrder findByOrderNumber(Integer orderNumber);
}
