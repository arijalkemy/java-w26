package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ISectorRepository extends JpaRepository<Sector, Integer> {
    Optional<Sector> findByCategoryAndWarehouse(Category category, Warehouse warehouse);
}