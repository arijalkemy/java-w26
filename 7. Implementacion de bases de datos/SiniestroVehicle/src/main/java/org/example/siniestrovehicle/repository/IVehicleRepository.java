package org.example.siniestrovehicle.repository;

import org.example.siniestrovehicle.entity.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT new map(v.patente as patente) FROM Vehicle v")
    List<HashMap<String, Object>> findAllPatente();

    @Query("SELECT new map(v.patente as patente, v.marca as marca) FROM Vehicle v ORDER BY v.anioFabricacion")
    List<HashMap<String, Object>> findPatenteMarcaOrderByAnioFabricacion();

    @Query("SELECT new map(v.patente as patente, v.marca as marca) FROM Vehicle v where v.cantidadRuedas > 4 AND v.anioFabricacion = :anio")
    List<HashMap<String, Object>> getAllPatenteAnioFabricacion(@Param("anio") Integer anio);
}
