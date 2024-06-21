package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository;

import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.ProductPromo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductPromoRepository extends JpaRepository<ProductPromo, Long>{
    Optional<ProductPromo> findById(Long id);
}
