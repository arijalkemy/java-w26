package com.mercadolibre.fresh_market.repository;

import com.mercadolibre.fresh_market.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {

    boolean existsByDescription(String description);

}
