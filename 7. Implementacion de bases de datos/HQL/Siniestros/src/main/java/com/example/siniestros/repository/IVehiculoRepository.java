package com.example.siniestros.repository;

import com.example.siniestros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("select v from Siniestro s join s.vehiculo v where s.perdidaEconomica > 10000")
    List<Vehiculo> getVehiculoWithSinister();
}
