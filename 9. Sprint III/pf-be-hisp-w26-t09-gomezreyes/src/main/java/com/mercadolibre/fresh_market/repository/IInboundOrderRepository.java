package com.mercadolibre.fresh_market.repository;

import com.mercadolibre.fresh_market.model.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInboundOrderRepository extends JpaRepository<InboundOrder,Long> {
}
