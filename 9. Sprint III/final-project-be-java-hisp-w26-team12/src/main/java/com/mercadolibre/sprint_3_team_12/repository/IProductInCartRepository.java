package com.mercadolibre.sprint_3_team_12.repository;

import com.mercadolibre.sprint_3_team_12.entity.ProductInCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductInCartRepository extends JpaRepository<ProductInCart, Long> {
}
