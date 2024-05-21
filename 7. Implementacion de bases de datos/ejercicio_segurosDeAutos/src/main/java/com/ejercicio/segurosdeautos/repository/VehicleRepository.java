package com.ejercicio.segurosdeautos.repository;

import com.ejercicio.segurosdeautos.model.Vehicle;
import com.ejercicio.segurosdeautos.repository.projections.PatentBrandModelProjection;
import com.ejercicio.segurosdeautos.repository.projections.PatentBrandProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT V.patent, V.brand, V.model FROM Vehicle V JOIN V.reported S WHERE S.economicLost > 10000")
    List<PatentBrandModelProjection> findVehiclesByEchonomicLostGreatherThan(); //creo que se recibe un objeto

    @Query("SELECT V.patent, V.brand, V.model, SUM(S.economicLost) FROM Vehicle V JOIN V.reported S WHERE S.economicLost > 10000 GROUP BY V.patent, V.brand, V.model")
    List<PatentBrandModelProjection> findVehiclesByEchonomicLost(); //creo que se recibe un objeto

    @Query("SELECT V.patent FROM Vehicle V")
    List<String> findAllPatents();

    @Query("SELECT V.patent, V.brand FROM Vehicle V order by V.febricationYear desc")
    List<PatentBrandProjection> findAllVehiclesOrderByFabricationYear();

    @Query("SELECT V.patent FROM Vehicle V WHERE V.wheels > 4 AND YEAR(V.febricationYear) = :currentYear")
    List<String> findPatentsByWheelsAndYear(int currentYear);
}
