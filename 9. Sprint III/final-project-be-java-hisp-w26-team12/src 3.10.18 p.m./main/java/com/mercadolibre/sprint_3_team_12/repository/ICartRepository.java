package com.mercadolibre.sprint_3_team_12.repository;

import com.mercadolibre.sprint_3_team_12.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart, Long> {
}
