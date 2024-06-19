package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInboundOrderRepository extends JpaRepository<InboundOrder, Integer> {
}