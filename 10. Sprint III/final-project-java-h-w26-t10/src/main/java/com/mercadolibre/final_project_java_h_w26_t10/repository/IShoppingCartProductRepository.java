package com.mercadolibre.final_project_java_h_w26_t10.repository;

import com.mercadolibre.final_project_java_h_w26_t10.entity.ShoppingCartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IShoppingCartProductRepository extends JpaRepository<ShoppingCartProduct, Integer> {
    List<ShoppingCartProduct> findDistinctByShoppingCartId(Integer id);
}