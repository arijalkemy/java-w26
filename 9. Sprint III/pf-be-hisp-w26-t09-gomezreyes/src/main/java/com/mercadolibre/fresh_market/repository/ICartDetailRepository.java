package com.mercadolibre.fresh_market.repository;

import com.mercadolibre.fresh_market.model.CartDetail;
import com.mercadolibre.fresh_market.model.ShoppingCartKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartDetailRepository extends JpaRepository<CartDetail, ShoppingCartKey>{
    List<CartDetail> findById_OrderId(Long orderId);
}
