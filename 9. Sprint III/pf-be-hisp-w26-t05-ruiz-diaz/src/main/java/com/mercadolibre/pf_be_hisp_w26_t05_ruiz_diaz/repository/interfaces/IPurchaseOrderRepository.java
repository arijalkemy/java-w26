package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces;


import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.OrderDetail;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPurchaseOrderRepository extends JpaRepository<PurchaseOrder,Integer> {

}
