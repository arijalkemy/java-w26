package com.mercadolibre.sprint3_individual_perez.repository;

import com.mercadolibre.sprint3_individual_perez.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart, Long> {
}
