package org.meli.ejercicio6_p1_d1_miniseries_h2.repository;

import org.meli.ejercicio6_p1_d1_miniseries_h2.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long> {

}
