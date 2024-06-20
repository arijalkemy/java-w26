package com.mercadolibre.fresh_market.repository;

import com.mercadolibre.fresh_market.model.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRefundRepository extends JpaRepository<Refund, Long>{
}
