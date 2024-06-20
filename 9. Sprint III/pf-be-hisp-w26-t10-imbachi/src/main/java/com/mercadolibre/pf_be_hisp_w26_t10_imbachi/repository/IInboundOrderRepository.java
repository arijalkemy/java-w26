package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInboundOrderRepository extends JpaRepository<InboundOrder, Integer> {
}