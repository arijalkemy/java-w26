package com.mercadolibre.fresh_market.repository;

import com.mercadolibre.fresh_market.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISectionRepository extends JpaRepository<Section,Long> {
    List<Section> findByWarehouseId(Long warehouseId);
}
