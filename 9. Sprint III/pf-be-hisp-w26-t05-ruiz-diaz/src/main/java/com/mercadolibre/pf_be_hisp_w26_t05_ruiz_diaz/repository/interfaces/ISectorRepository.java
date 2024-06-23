package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISectorRepository extends JpaRepository<Sector, Integer> {
}
