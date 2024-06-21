package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    @Query("SELECT SUM(sc.total) " +
            "FROM ShoppingCart sc " +
            "JOIN sc.shoppingCartProducts sp " +
            "JOIN sp.product p " +
            "JOIN p.batches b " +
            "JOIN b.sector s " +
            "JOIN s.warehouse w " +
            "WHERE w.id = :warehouse_id " +
            "AND sc.orderDate >= :thirtyDaysAgo ")
    double getTotalSalesForMonth(@Param("warehouse_id") Integer warehouse_id,@Param("thirtyDaysAgo") LocalDate thirtyDaysAgo);

    @Query("SELECT sc FROM ShoppingCart sc " +
            "JOIN sc.shoppingCartProducts sp " +
            "JOIN sp.product p " +
            "JOIN p.batches b " +
            "JOIN b.sector s " +
            "JOIN s.warehouse w " +
            "WHERE w.id = :idWarehouse " +
            "AND sc.orderState = 'completed' " +
            "AND sc.orderDate >= :thirtyDaysAgo")
    List<ShoppingCart> findSalesInLastMonth(@Param("idWarehouse") Integer idWarehouse,@Param("thirtyDaysAgo") LocalDate thirtyDaysAgo);


}