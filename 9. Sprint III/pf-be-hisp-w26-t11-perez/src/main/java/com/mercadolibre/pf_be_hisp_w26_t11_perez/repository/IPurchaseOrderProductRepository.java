package com.mercadolibre.pf_be_hisp_w26_t11_perez.repository;

import com.mercadolibre.pf_be_hisp_w26_t11_perez.dto.frescos.ProductSimpleResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t11_perez.model.PurchaseOrder;
import com.mercadolibre.pf_be_hisp_w26_t11_perez.model.PurchaseOrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPurchaseOrderProductRepository extends JpaRepository<PurchaseOrderProduct,Integer> {

    @Query("SELECT new com.mercadolibre.pf_be_hisp_w26_t11_perez.dto.frescos.ProductSimpleResponseDTO(p.name, p.price)" +
            "FROM PurchaseOrderProduct pop JOIN pop.product p WHERE pop.purchaseOrder.id = :purchaseOrderId")
    List<ProductSimpleResponseDTO> findProductsByOrderId(Integer purchaseOrderId);


    void deleteAllByPurchaseOrder(PurchaseOrder purchaseOrder);

    List<PurchaseOrderProduct> findAllByPurchaseOrder(PurchaseOrder purchaseOrder);
}
