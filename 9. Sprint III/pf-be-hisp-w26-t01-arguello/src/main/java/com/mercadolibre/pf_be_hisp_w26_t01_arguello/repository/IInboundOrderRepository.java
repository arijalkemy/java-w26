package com.mercadolibre.pf_be_hisp_w26_t01_arguello.repository;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInboundOrderRepository extends JpaRepository<InboundOrder, Integer> {

    List<InboundOrder> findAllBySection_Warehouse_Id(int idWarehouse);
}
