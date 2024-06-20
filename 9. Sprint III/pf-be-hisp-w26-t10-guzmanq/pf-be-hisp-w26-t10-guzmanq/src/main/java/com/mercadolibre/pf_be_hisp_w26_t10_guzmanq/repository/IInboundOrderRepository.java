package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IInboundOrderRepository extends JpaRepository<InboundOrder, Integer> {
//    @Query("SELECT COUNT(io) " +
//            "FROM InboundOrder io " +
//            "JOIN io.warehouse w " +
//            "WHERE w.id = :warehouse_id ")
//    double getCantInboundOrderForMonth(@Param("warehouse_id") Integer warehouse_id);
}