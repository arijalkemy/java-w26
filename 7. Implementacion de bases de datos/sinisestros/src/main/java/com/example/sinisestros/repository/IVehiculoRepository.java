package com.example.sinisestros.repository;

import com.example.sinisestros.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    //Listar las patentes de todos los vehículos registrados.
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> getAllPatentes();

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<Map<String, String>> getAllPatentesYMarcas();


    // Listar la patente de todos los vehículos que tengan más de cuatro ruedas
    // y hayan sido fabricados en el corriente año.
    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas >4 AND v.anioFabricacion = 2024")
    List<String> getPatentesMasDeCuatroRuedasAnioActual();

}
