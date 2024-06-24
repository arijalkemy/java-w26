package com.mercadolibre.project_java_w26_team13.repository;

import com.mercadolibre.project_java_w26_team13.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartDetailRepository extends JpaRepository<CartDetail, Long>{
    List<CartDetail> findByCartId(Long cartId);
}
