package com.mercadolibre.sprint_3_team_12_malacara.repository;

import com.mercadolibre.sprint_3_team_12_malacara.entity.ProductInCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductInCartRepository extends JpaRepository<ProductInCart, Long> {
}
