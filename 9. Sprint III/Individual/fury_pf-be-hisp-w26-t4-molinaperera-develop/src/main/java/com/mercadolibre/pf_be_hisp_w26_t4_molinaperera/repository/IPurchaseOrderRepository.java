package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository;

import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    List<PurchaseOrder> findAll();
    Optional<PurchaseOrder> findById(Long id);
}
