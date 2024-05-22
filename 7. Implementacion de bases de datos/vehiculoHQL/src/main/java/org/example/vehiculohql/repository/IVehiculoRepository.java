package org.example.vehiculohql.repository;

import org.example.vehiculohql.dto.TotalSiniestroDto;
import org.example.vehiculohql.dto.VehiculoPatenteMarcaDTO;
import org.example.vehiculohql.model.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends CrudRepository<Vehiculo, Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    @Query("SELECT new Vehiculo(v.patente, v.marca) FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<Vehiculo> findAllOrderByAnioFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas >= 4 AND v.anioFabricacion = :anioActual")
    List<String> findAllPatentesByCantidadRuedasAndAnio(@Param("anioActual") int anioActual);

    @Query("SELECT v FROM Vehiculo v WHERE v.id IN " +
            "(SELECT s.vehiculoDenunciado.id FROM Siniestro AS s WHERE s.perdidaEconomica >= :perdida)")
    List<Vehiculo> findAllSiniestroMayorA(@Param("perdida") Double perdida);

    @Query("SELECT v.patente AS patente, " +
            " v.marca AS marca, v.modelo AS modelo, " +
            " SUM(s.perdidaEconomica) AS total FROM Vehiculo v " +
            " INNER JOIN Siniestro s ON v.id = s.vehiculoDenunciado.id " +
            " WHERE s.perdidaEconomica >= :perdida GROUP BY v.id ")
    List<TotalSiniestroDto> getTotalSiniestro(@Param("perdida") Double perdida);
}
