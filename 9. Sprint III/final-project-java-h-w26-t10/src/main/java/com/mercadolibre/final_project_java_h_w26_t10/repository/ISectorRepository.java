package com.mercadolibre.final_project_java_h_w26_t10.repository;

import com.mercadolibre.final_project_java_h_w26_t10.entity.Category;
import com.mercadolibre.final_project_java_h_w26_t10.entity.Sector;
import com.mercadolibre.final_project_java_h_w26_t10.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ISectorRepository extends JpaRepository<Sector, Integer> {
    Optional<Sector> findByCategoryAndWarehouse(Category category, Warehouse warehouse);
}
