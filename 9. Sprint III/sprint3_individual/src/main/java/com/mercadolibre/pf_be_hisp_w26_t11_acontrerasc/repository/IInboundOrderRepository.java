package com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.repository;

import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.model.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInboundOrderRepository extends JpaRepository<InboundOrder,Integer> {
    InboundOrder findByOrderNumber(Integer orderNumber);
}
