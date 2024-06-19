package com.mercadolibre.meli_frescos.repository;

import com.mercadolibre.meli_frescos.model.PurchaseOrder;
import com.mercadolibre.meli_frescos.dto.frescos.ProductSimpleResponseDTO;
import com.mercadolibre.meli_frescos.model.PurchaseOrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPurchaseOrderProductRepository extends JpaRepository<PurchaseOrderProduct,Integer> {

    @Query("SELECT new com.mercadolibre.meli_frescos.dto.frescos.ProductSimpleResponseDTO(p.name, p.price)" +
            "FROM PurchaseOrderProduct pop JOIN pop.product p WHERE pop.purchaseOrder.id = :purchaseOrderId")
    List<ProductSimpleResponseDTO> findProductsByOrderId(Integer purchaseOrderId);


    void deleteAllByPurchaseOrder(PurchaseOrder purchaseOrder);
}
