package com.mercadolibre.fresh_market.repository;

import com.mercadolibre.fresh_market.model.PurchaseOrder;
import com.mercadolibre.fresh_market.model.ShoppingCartKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {


}
