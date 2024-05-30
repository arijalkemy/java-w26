package com.mercadolibre.Vehiculos_Sinietros.repository;

import com.mercadolibre.Vehiculos_Sinietros.model.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
}
