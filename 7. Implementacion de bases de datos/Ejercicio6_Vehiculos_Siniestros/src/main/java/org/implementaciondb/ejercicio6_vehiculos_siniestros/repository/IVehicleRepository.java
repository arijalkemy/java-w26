package org.implementaciondb.ejercicio6_vehiculos_siniestros.repository;

import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.entity.Vehicle;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.projection.PartialVehicle;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.projection.PartialVehicleAndEconomicLoss;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.projection.PatentAndBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT DISTINCT v.patent " +
            "FROM Vehicle v " +
            "ORDER BY v.patent")
    List<String> findAllPatents();

    @Query("SELECT v.patent AS patent, v.brand AS brand " +
            "FROM Vehicle v " +
            "ORDER BY v.manufactureYear")
    List<PatentAndBrand> findAllByPatentsAndBrandOrderByManufacturedYear();

    @Query("SELECT v.patent " +
            "FROM Vehicle v " +
            "WHERE v.numberOfWheels > 4 AND v.manufactureYear = YEAR(CURRENT_DATE )"
    )// AND EXTRACT(YEAR FROM v.manufactureYear) = EXTRACT(YEAR FROM CURRENT_DATE)")
    List<String> findAllByPatentsByNumberOfWheelsAndManufacturedYear();

    @Query("SELECT v.brand AS brand, v.model AS model, v.patent AS patent " +
            "FROM Vehicle v JOIN v.sinisters s " +
            "WHERE s.economicLoss > 10000")
    List<PartialVehicle> findByEconomicLoss();

    @Query("SELECT v.brand AS brand, v.model AS model, v.patent AS patent, s.economicLoss AS economicLoss " +
            "FROM Vehicle v JOIN v.sinisters s " +
            "WHERE s.economicLoss > 10000")
    List<PartialVehicleAndEconomicLoss> findByEconomicLossDetails();

}
