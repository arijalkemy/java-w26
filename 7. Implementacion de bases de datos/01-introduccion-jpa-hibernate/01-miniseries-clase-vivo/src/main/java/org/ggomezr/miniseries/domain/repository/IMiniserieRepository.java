package org.ggomezr.miniseries.domain.repository;

import org.ggomezr.miniseries.domain.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long>{
}
