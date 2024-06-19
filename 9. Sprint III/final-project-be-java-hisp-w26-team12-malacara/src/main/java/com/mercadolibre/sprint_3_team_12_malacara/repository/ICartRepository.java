package com.mercadolibre.sprint_3_team_12_malacara.repository;

import com.mercadolibre.sprint_3_team_12_malacara.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart, Long> {
}
