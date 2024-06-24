package com.mercadolibre.project_java_w26_team13.repository;

import com.mercadolibre.project_java_w26_team13.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISectionRepository extends JpaRepository<Section,Long> {
    Section findById(long id);
    boolean existsByWarehouseId(Long id);

}
