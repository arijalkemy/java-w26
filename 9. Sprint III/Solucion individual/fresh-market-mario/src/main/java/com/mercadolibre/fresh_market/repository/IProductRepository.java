package com.mercadolibre.fresh_market.repository;

import com.mercadolibre.fresh_market.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAll();
}
