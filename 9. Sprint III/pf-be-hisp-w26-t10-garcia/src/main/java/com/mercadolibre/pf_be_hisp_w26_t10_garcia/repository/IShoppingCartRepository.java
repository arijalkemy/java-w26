package com.mercadolibre.pf_be_hisp_w26_t10_garcia.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
}