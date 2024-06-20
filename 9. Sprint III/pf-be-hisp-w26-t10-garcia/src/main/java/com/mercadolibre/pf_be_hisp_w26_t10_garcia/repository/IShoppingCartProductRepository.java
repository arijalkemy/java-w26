package com.mercadolibre.pf_be_hisp_w26_t10_garcia.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.ShoppingCartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IShoppingCartProductRepository extends JpaRepository<ShoppingCartProduct, Integer> {
    List<ShoppingCartProduct> findDistinctByShoppingCardId(Integer id);
}