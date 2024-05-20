package org.ggomezr.joyerialasperlas.domain.repository;

import org.ggomezr.joyerialasperlas.domain.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {
}
