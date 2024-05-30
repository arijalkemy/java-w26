package com.mercadolibre.Vehiculos_Sinietros.repository;

import com.mercadolibre.Vehiculos_Sinietros.model.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {

    @Query("SELECT v.patente " +
            "FROM Vehiculo v")
    List<Vehiculo> findPatentAllVehicle();

    @Query("SELECT v.patente, v.marca " +
            "FROM Vehiculo v " +
            "ORDER BY v.año_fabricacion")
    List<Vehiculo> findPatentAndBrandAllVehicleOrderByYearManufacture();

    @Query("SELECT v.patente " +
            "FROM Vehiculo v " +
            "WHERE v.cant_ruedas > 5 and YEAR(v.año_fabricacion) = YEAR(CURRENT_DATE) ")
    List<Vehiculo> findPatentAllVehicleWithFourWheelsAndManufactureCurrentYear();

    @Query("SELECT v.id_vehiculo, v.marca, v.modelo " +
            "FROM Vehiculo v " +
            "JOIN Siniestro s ON s.Id_vehículo_denunciado.id_vehiculo = v.id_vehiculo " +
            "WHERE s.perdida_económica > 10000 ")
    List<Vehiculo> findAllVehicleWithCrashOver10000();

    @Query("SELECT v.id_vehiculo, v.marca, v.modelo, SUM(s.perdida_económica) " +
            "FROM Vehiculo v " +
            "JOIN Siniestro s ON s.Id_vehículo_denunciado.id_vehiculo = v.id_vehiculo " +
            "WHERE s.perdida_económica > 10000" +
            "GROUP BY v.id_vehiculo, v.marca, v.modelo ")
    List<Vehiculo> findAllVehicleWithCrashOver10000AndTotalLoss();

}
