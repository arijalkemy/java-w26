package com.mercadolibre.concesionaria.repository;

import com.mercadolibre.concesionaria.model.Vehiculo;
import com.mercadolibre.concesionaria.projections.PatenteYMarca;
import com.mercadolibre.concesionaria.projections.SiniestroMayorA10000;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("select e.patente as patente from Vehiculo e")
    List<String> findVehiculosConPatentes();

    @Query("SELECT e.patente AS patente, e.marca AS marca FROM Vehiculo e ORDER BY e.anoDeFabricacion")
    List<PatenteYMarca> findVehiculosConPatentesYMarca();

    @Query("select e.patente AS patente FROM Vehiculo e WHERE e.cantidadDeRuedas > 4 AND e.anoDeFabricacion = 2024")
    List<String> findPatentesSegunCantidadDeRuedasYAnoDeFabricacion();

    @Query("select e.patente AS patente, e.marca AS marca, e.modelo AS modelo " +
            "FROM Vehiculo e " +
            "JOIN e.siniestros sin " +
            "WHERE sin.perdidaEconomica > 10000")
    List<SiniestroMayorA10000> findVehiculosConSiniestrosMayoresA10000();
}
