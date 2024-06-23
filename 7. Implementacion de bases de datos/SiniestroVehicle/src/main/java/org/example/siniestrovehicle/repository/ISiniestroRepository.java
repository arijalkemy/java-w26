package org.example.siniestrovehicle.repository;

import org.example.siniestrovehicle.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {

    @Query("SELECT new map(s.precioSiniestro as precio) FROM Siniestro s")
    List<HashMap<String, Object>> findAllPatente();

    @Query("SELECT new map(s.vehiculo.patente as patente, s.vehiculo.marca as marca, s.vehiculo.modelo as modelo) " +
            "FROM Siniestro s " +
            "WHERE s.precioSiniestro > 10000")
    List<HashMap<String, Object>> findSiniestroMoreThat10000();

    @Query("SELECT new map(s.vehiculo.patente as patente, s.vehiculo.marca as marca, s.vehiculo.modelo as modelo, " +
            "s.precioSiniestro as perdida) " +
            "FROM Siniestro s " +
            "WHERE s.precioSiniestro > 10000")
    List<HashMap<String, Object>> findSiniestroPerdidaMoreThat10000();
}
