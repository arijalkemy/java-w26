package com.mercadolibre.pf_be_hisp_w26_t4_aquino.repository;

import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISectionRepository extends JpaRepository<Section,Long> {
}
