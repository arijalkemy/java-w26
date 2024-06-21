package com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces;

import com.mercadolibre.project_be_java_hisp_w26_team5.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISectorRepository extends JpaRepository<Sector, Integer> {
}
