package com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces;

import com.mercadolibre.project_be_java_hisp_w26_team5.model.OrderDetail;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    void deleteAllByOrder(PurchaseOrder order);
}
