package com.mercadolibre.pf_be_hisp_w26_t01_ditta.repository;

import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISectionRepository extends JpaRepository<Section, Integer> {
    List<Section> findAllByWarehouseId(Integer warehouseId);
}
