package com.mercadolibre.final_project_java_h_w26_t10.repository;

import com.mercadolibre.final_project_java_h_w26_t10.entity.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInboundOrderRepository extends JpaRepository<InboundOrder, Integer> {
}
