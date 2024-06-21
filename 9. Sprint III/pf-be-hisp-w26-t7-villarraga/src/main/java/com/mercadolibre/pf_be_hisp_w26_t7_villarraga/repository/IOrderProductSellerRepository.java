package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.repository;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.OrderProductSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderProductSellerRepository extends JpaRepository<OrderProductSeller, Long> {
}
