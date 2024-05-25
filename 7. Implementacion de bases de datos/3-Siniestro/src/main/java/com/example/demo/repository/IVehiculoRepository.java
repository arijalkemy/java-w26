package com.example.demo.repository;

import com.example.demo.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    @Query("SELECT v.patente AS patente, v.marca AS marca FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<Object[]> findAllPatenteAndMarcaOrderByAnioFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas > 4 AND v.anioFabricacion = YEAR(CURRENT_DATE)")
    List<String> findPatenteByRuedasYAnio();

}
