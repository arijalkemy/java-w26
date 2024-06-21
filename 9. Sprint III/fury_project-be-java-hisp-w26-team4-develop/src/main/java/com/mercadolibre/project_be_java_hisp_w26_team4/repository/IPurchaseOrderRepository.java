package com.mercadolibre.project_be_java_hisp_w26_team4.repository;

import com.mercadolibre.project_be_java_hisp_w26_team4.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    List<PurchaseOrder> findAll();
    Optional<PurchaseOrder> findById(Long id);
}
