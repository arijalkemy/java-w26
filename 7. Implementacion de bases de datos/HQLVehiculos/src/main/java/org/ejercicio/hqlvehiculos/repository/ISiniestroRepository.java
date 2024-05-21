package org.ejercicio.hqlvehiculos.repository;

import org.ejercicio.hqlvehiculos.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {

}
