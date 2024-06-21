package com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces;


import com.mercadolibre.project_be_java_hisp_w26_team5.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseOrderRepository extends JpaRepository<PurchaseOrder,Integer> {

}
