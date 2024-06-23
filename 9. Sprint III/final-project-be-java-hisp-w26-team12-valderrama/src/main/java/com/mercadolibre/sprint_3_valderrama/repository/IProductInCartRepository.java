package com.mercadolibre.sprint_3_valderrama.repository;

import com.mercadolibre.sprint_3_valderrama.entity.ProductInCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductInCartRepository extends JpaRepository<ProductInCart, Long> {
}
