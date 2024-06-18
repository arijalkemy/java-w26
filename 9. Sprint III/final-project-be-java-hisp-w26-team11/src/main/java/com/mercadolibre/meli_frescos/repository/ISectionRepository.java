package com.mercadolibre.meli_frescos.repository;

import com.mercadolibre.meli_frescos.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISectionRepository extends JpaRepository<Section,Integer> {
}
