package com.mercadolibre.pf_be_hisp_w26_t10_meza.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ISectorRepository extends JpaRepository<Sector, Integer> {
    Optional<Sector> findByCategoryAndWarehouse(Category category, Warehouse warehouse);
}
