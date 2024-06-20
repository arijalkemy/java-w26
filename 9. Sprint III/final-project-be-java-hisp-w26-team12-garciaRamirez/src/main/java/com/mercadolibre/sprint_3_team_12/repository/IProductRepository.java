package com.mercadolibre.sprint_3_team_12.repository;

import com.mercadolibre.sprint_3_team_12.entity.Product;
import com.mercadolibre.sprint_3_team_12.enums.Category;
import com.mercadolibre.sprint_3_team_12.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);

    @Query("SELECT p.id AS idProduct, SUM(bs.currentQuantity) AS quantity FROM Product p LEFT JOIN p.batchStocks bs GROUP BY p.id")
    List<ProductProjection> findAllProducts();
    @Query("SELECT p.id AS idProduct, SUM(bs.currentQuantity) AS quantity FROM Product p LEFT JOIN p.batchStocks bs WHERE p.type = :category GROUP BY p.id")
    List<ProductProjection> findProductsByCategory(Category category);
}
