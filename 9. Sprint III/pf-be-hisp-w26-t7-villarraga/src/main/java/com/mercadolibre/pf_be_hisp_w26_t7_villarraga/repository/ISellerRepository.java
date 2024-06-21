package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.repository;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISellerRepository extends JpaRepository<Seller, Long> {
}
