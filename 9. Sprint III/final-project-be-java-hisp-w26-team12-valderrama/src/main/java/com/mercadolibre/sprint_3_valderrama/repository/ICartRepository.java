package com.mercadolibre.sprint_3_valderrama.repository;

import com.mercadolibre.sprint_3_valderrama.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart, Long> {
}
