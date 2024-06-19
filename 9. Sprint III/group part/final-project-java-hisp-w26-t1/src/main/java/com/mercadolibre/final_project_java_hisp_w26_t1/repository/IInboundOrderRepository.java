package com.mercadolibre.final_project_java_hisp_w26_t1.repository;

import com.mercadolibre.final_project_java_hisp_w26_t1.entity.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInboundOrderRepository extends JpaRepository<InboundOrder, Integer> {
}
