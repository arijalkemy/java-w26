package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ISectorRepository extends JpaRepository<Sector, Integer> {
    Optional<Sector> findByCategoryAndWarehouse(Category category, Warehouse warehouse);
}