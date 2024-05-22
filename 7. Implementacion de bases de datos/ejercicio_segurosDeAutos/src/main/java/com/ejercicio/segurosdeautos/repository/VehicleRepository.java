package com.ejercicio.segurosdeautos.repository;

import com.ejercicio.segurosdeautos.model.Vehicle;
import com.ejercicio.segurosdeautos.proyections.VehicleProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT SUM(S.economicLost) AS economicLost FROM Vehicle V JOIN V.reported S WHERE S.economicLost > 10000")
    List<VehicleProjections> findTotalEchonomicLostGreatherThan();

    @Query("SELECT V.patent AS patent, V.brand AS brand, V.model AS model, SUM(S.economicLost) AS economicLost FROM Vehicle V JOIN V.reported S GROUP BY V.patent, V.brand, V.model")
    List<VehicleProjections> findVehiclesByEchonomicLost();

    @Query("SELECT V.id AS id ,V.patent AS patent FROM Vehicle V")
    List<VehicleProjections> findAllPatents();

    @Query("SELECT V.id AS id ,V.patent AS patent, V.brand AS brand FROM Vehicle V order by V.febricationYear desc")
    List<VehicleProjections> findAllVehiclesOrderByFabricationYear();

    @Query("SELECT V.id AS id ,V.patent AS patent FROM Vehicle V WHERE V.wheels > 4 AND YEAR(V.febricationYear) = :currentYear")
    List<VehicleProjections> findPatentsByWheelsAndYear(int currentYear);
}