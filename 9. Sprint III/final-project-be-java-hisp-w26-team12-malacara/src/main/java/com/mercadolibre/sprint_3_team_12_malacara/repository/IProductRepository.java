package com.mercadolibre.sprint_3_team_12_malacara.repository;

import com.mercadolibre.sprint_3_team_12_malacara.entity.Product;
import com.mercadolibre.sprint_3_team_12_malacara.enums.Category;
import com.mercadolibre.sprint_3_team_12_malacara.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p.id AS idProduct, SUM(bs.currentQuantity) AS quantity FROM Product p LEFT JOIN p.batchStocks bs GROUP BY p.id")
    List<ProductProjection> findAllProducts();

    @Query("SELECT p.id AS idProduct, SUM(bs.currentQuantity) AS quantity FROM Product p LEFT JOIN p.batchStocks bs WHERE p.type = :category GROUP BY p.id")
    List<ProductProjection> findProductsByCategory(Category category);

    @Query("SELECT p.id AS idProduct, SUM(bs.currentQuantity) AS quantity FROM Product p LEFT JOIN p.batchStocks bs WHERE bs.user.id = :userId GROUP BY p.id")
    List<ProductProjection> findAllProductsBySeller(Long userId);

    @Query("SELECT p.id AS idProduct, SUM(bs.currentQuantity) AS quantity FROM Product p LEFT JOIN p.batchStocks bs WHERE bs.user.id = :userId GROUP BY p.id HAVING SUM(bs.currentQuantity) <= :quantity")
    List<ProductProjection> findAllProductsBySellerAndQuantity(Long userId, double quantity);
}
