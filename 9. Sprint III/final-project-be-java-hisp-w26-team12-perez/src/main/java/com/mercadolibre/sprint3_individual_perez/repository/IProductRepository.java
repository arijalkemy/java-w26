package com.mercadolibre.sprint3_individual_perez.repository;

import com.mercadolibre.sprint3_individual_perez.entity.Product;
import com.mercadolibre.sprint3_individual_perez.entity.User;
import com.mercadolibre.sprint3_individual_perez.enums.Category;
import com.mercadolibre.sprint3_individual_perez.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p.id AS idProduct, SUM(bs.currentQuantity) AS quantity FROM Product p LEFT JOIN p.batchStocks bs GROUP BY p.id")
    List<ProductProjection> findAllProducts();
    @Query("SELECT p.id AS idProduct, SUM(bs.currentQuantity) AS quantity FROM Product p LEFT JOIN p.batchStocks bs WHERE p.type = :category GROUP BY p.id")
    List<ProductProjection> findProductsByCategory(Category category);

    Optional<Product> findProductByName(String name);

    List<Product> getProductsBySeller(User seller);
}
