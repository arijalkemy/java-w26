package com.bootcamp.vehiculo.repository;

import com.bootcamp.vehiculo.model.Vehiculo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    List<Vehiculo> findAllByOrderByAnioFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas > 4 AND v.anioFabricacion = 2024")
    List<String> findPatentesByCuatroRuedasAndAnioFabricacion();

    @Query("SELECT v FROM Vehiculo v WHERE v.id IN (SELECT s.id FROM Siniestro AS s WHERE s.perdidaEconomica>= :perdida)")
    List<Vehiculo> findSiniestroMayorA(@Param("perdida") Integer perdida);
}
