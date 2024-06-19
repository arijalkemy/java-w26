package org.bootcamp.ejerciciodeportistas.repository;

import org.bootcamp.ejerciciodeportistas.model.DeportePorPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeportePorPersonaRepository extends JpaRepository<DeportePorPersona, Long> {
}
