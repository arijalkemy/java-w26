package com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
}
