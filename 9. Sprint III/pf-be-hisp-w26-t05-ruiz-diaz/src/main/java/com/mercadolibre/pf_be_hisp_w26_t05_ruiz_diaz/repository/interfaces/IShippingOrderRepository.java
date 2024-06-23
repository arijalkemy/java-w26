package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.enums.ShippingOrderState;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.ShippingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShippingOrderRepository extends JpaRepository<ShippingOrder, Integer> {
    List<ShippingOrder> findByState(ShippingOrderState status);
}
