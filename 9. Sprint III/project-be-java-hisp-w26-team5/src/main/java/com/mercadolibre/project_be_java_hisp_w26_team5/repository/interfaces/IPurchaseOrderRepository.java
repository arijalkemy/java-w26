package com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces;


import com.mercadolibre.project_be_java_hisp_w26_team5.model.OrderDetail;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPurchaseOrderRepository extends JpaRepository<PurchaseOrder,Integer> {

}
