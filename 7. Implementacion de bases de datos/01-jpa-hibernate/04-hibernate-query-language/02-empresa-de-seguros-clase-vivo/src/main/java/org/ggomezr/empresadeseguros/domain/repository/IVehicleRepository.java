package org.ggomezr.empresadeseguros.domain.repository;

import org.ggomezr.empresadeseguros.domain.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT DISTINCT v.patent FROM Vehicle v")
    List<String> findAllByPatents();

    @Query("SELECT v.patent FROM Vehicle v ORDER BY v.fabricationYear")
    List<String> findAllByPatentAndBrandOrderByFabricationYear();

    @Query("SELECT v.patent FROM Vehicle v WHERE v.numberOfWheels > 4 AND v.fabricationYear = YEAR(CURRENT_DATE)")
    List<String> findAllByPatentWithMoreThanFourWheelsAndFabricatedThisYear();

    @Query("SELECT v.patent, v.brand, v.model, v.fabricationYear, v.numberOfWheels, s.economicLoss " +
            "FROM Vehicle v JOIN v.sinisters s WHERE s.economicLoss > 10000")
    List<String> findAllBySinisterEconomicLossGreaterThan10000();

    @Query("SELECT v.patent, v.brand, v.model, SUM(s.economicLoss) " +
            "FROM Vehicle v JOIN v.sinisters s " +
            "WHERE s.economicLoss > 10000 " +
            "GROUP BY v.patent, v.brand, v.model")
    List<String> findAllVehiclesWithMajorLosses();
}
