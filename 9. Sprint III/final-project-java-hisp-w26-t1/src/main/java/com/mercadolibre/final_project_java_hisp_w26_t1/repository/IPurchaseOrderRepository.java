package com.mercadolibre.final_project_java_hisp_w26_t1.repository;

import com.mercadolibre.final_project_java_hisp_w26_t1.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPurchaseOrderRepository extends JpaRepository<PurchaseOrder,Integer> {
    Optional<PurchaseOrder> findPurchaseOrderById(Integer id);
}
