package com.mercadolibre.pf_be_hisp_w26_t11_pacheco.repository;

import com.mercadolibre.pf_be_hisp_w26_t11_pacheco.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISectionRepository extends JpaRepository<Section,Integer> {
}
