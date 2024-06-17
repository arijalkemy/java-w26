package org.bootcamp.ejerciciodeportistas.repository;

import org.bootcamp.ejerciciodeportistas.model.Deporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeporteRepository extends JpaRepository<Deporte, Long> {
    Deporte findByNombre(String nombre);
}
