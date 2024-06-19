package com.mercadolibre.sprint3_individual_perez.repository;

import com.mercadolibre.sprint3_individual_perez.entity.ProductInCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductInCartRepository extends JpaRepository<ProductInCart, Long> {
}
