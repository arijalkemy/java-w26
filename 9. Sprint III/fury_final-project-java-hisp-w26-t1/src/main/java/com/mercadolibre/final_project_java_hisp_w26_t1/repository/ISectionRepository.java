package com.mercadolibre.final_project_java_hisp_w26_t1.repository;

import com.mercadolibre.final_project_java_hisp_w26_t1.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISectionRepository extends JpaRepository<Section, Integer> {
}
