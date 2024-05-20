package org.bootcamp.miniserie.repository;

import org.bootcamp.miniserie.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
