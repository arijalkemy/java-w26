package com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IInboundOrderRepository extends JpaRepository<InboundOrder, Long> {
    Optional<InboundOrder> findTopByOrderByOrderNumberDesc();
}
