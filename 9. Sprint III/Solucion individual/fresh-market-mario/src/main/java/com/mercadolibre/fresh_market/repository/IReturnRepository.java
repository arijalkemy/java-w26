package com.mercadolibre.fresh_market.repository;

import com.mercadolibre.fresh_market.model.Product;
import com.mercadolibre.fresh_market.model.PurchaseOrder;
import com.mercadolibre.fresh_market.model.Returns;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IReturnRepository extends JpaRepository<Returns, Long>{
    Optional<Returns> findByPurchaseOrderAndProduct(PurchaseOrder purchaseOrder, Product product);
    List<Returns> findByStatusIgnoreCase(String status);


}
