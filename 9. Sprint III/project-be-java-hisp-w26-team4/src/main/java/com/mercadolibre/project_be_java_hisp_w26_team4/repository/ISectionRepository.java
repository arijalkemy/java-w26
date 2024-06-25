package com.mercadolibre.project_be_java_hisp_w26_team4.repository;

import com.mercadolibre.project_be_java_hisp_w26_team4.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISectionRepository extends JpaRepository<Section,Long> {
}
