package org.implementaciondb.ejercicio6_vehiculos_siniestros.repository;

import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.entity.Vehicle;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.entity.VehiculoSiniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT DISTINCT v.patent FROM Vehicle v")
    List<String> findAllPatents();

    @Query("SELECT v.patent, v.brand FROM Vehicle v ORDER BY v.manufactureYear")
    List<?> findAllByPatentsAndBrandOrderByManufacturedYear();

    /*@Query("SELECT v.patent FROM Vehicle v WHERE v.numberOfWheels > 4 AND EXTRACT(YEAR FROM v.manufactureYear) = EXTRACT(YEAR FROM CURRENT_DATE)")
    List<String> findAllPatentsByNumberOfWheelsAndManufacturedYear();*/

    @Query("SELECT v.brand, v.model, v.patent FROM Vehicle v JOIN v.sinisters s WHERE s.economicLoss > 10000")
    List<Object[]> findByEconomicLoss();

    @Query("SELECT v.brand, v.model, v.patent, s.economicLoss FROM Vehicle v JOIN v.sinisters s WHERE s.economicLoss > 10000")
    List<Object[]> findByEconomicLossDetails();

}
