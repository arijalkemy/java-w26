package com.mercadolibre.pf_be_hisp_w26_t1_cugura.repository;

import com.mercadolibre.pf_be_hisp_w26_t1_cugura.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPurchaseOrderRepository extends JpaRepository<PurchaseOrder,Integer> {
    Optional<PurchaseOrder> findPurchaseOrderById(Integer id);
}
