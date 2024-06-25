package com.mercadolibre.pf_be_hisp_w26_t07_torres.repository;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.OrderProductSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderProductSellerRepository extends JpaRepository<OrderProductSeller, Long> {
}
