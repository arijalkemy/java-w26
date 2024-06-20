package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.ShoppingCartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IShoppingCartProductRepository extends JpaRepository<ShoppingCartProduct, Integer> {
    List<ShoppingCartProduct> findDistinctByShoppingCartId(Integer id);

//    @Query("SELECT SUM(scp.quantity) " +
//            "FROM ShoppingCartProduct scp " +
//            "JOIN scp.shoppingCart sc " +
//            "JOIN scp.product p " +
//            "JOIN p.batches b " +
//            "JOIN b.sector s " +
//            "JOIN s.warehouse w " +
//            "WHERE w.id = :warehouse_id " +
//            "AND sc.orderDate >= current_date - 30")
//    double getTotalProductsSalesForMonth(@Param("warehouse_id") Integer warehouse_id);
}