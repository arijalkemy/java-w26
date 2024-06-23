package com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces;

import com.mercadolibre.project_be_java_hisp_w26_team5.enums.ShippingOrderState;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.ShippingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShippingOrderRepository extends JpaRepository<ShippingOrder, Integer> {
    List<ShippingOrder> findByState(ShippingOrderState status);
}
