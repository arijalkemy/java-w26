package com.mercadolibre.pf_be_hisp_w26_t11_roman.repository;

import com.mercadolibre.pf_be_hisp_w26_t11_roman.dto.StarProductsDTO;
import com.mercadolibre.pf_be_hisp_w26_t11_roman.dto.frescos.ProductSimpleResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t11_roman.model.Product;
import com.mercadolibre.pf_be_hisp_w26_t11_roman.model.PurchaseOrder;
import com.mercadolibre.pf_be_hisp_w26_t11_roman.model.PurchaseOrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPurchaseOrderProductRepository extends JpaRepository<PurchaseOrderProduct,Integer> {

    @Query("SELECT new com.mercadolibre.pf_be_hisp_w26_t11_roman.dto.frescos.ProductSimpleResponseDTO(p.name, p.price)" +
            "FROM PurchaseOrderProduct pop JOIN pop.product p WHERE pop.purchaseOrder.id = :purchaseOrderId")
    List<ProductSimpleResponseDTO> findProductsByOrderId(Integer purchaseOrderId);


    List<PurchaseOrderProduct> findAllByPurchaseOrder(PurchaseOrder purchaseOrder);


    void deleteAllByPurchaseOrder(PurchaseOrder purchaseOrder);


    @Query("SELECT new com.mercadolibre.pf_be_hisp_w26_t11_roman.dto.StarProductsDTO(pop.product.id, " +
            "SUM(pop.productQuantity), COUNT(pop.purchaseOrder.id)) " +
            "FROM PurchaseOrderProduct pop " +
            "GROUP BY pop.product.id " +
            "ORDER BY SUM(pop.productQuantity) DESC, SUM(pop.purchaseOrder.id)  DESC")
    List<StarProductsDTO> findStarProducts();
}
