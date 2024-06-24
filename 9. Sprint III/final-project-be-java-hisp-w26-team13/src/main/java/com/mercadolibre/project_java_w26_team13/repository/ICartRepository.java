package com.mercadolibre.project_java_w26_team13.repository;

import com.mercadolibre.project_java_w26_team13.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository  extends JpaRepository<Cart, Long> {
}
