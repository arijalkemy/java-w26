package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository;

import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInboundOrderRepository extends JpaRepository<InboundOrder, Long> {
}
