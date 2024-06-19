package com.mercadolibre.meli_frescos.repository;


import com.mercadolibre.meli_frescos.model.PurchaseOrder;
import com.mercadolibre.meli_frescos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPurchaseOrderRepository extends JpaRepository<PurchaseOrder,Integer> {

    Optional<PurchaseOrder> findByBuyer(User buyer);

    @Query("SELECT po FROM PurchaseOrder po WHERE po.buyer.id = :buyerId")
    Optional<PurchaseOrder> findByBuyerId(Long buyerId);

}
