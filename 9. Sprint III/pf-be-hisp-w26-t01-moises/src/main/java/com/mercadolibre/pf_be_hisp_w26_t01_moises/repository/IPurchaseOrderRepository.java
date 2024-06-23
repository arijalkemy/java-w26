package com.mercadolibre.pf_be_hisp_w26_t01_moises.repository;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPurchaseOrderRepository extends JpaRepository<PurchaseOrder,Integer> {
    Optional<PurchaseOrder> findPurchaseOrderById(Integer id);
    List<PurchaseOrder> findAllByUser_Id(Integer userId);
}
