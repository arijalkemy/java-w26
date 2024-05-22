package org.ggomezr.empresadeseguros.domain.repository;

import org.ggomezr.empresadeseguros.domain.model.Sinister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISinisterRepository extends JpaRepository<Sinister, Long> {
}
