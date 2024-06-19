package com.mercadolibre.fresh_market.repository;

import com.mercadolibre.fresh_market.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISectionRepository extends JpaRepository<Section,Long> {
    List<Section> findByWarehouseId(Long warehouseId);
}
