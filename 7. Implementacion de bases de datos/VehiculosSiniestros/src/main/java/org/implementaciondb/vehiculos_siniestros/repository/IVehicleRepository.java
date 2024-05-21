package org.implementaciondb.vehiculos_siniestros.repository;

import org.implementaciondb.vehiculos_siniestros.model.entity.Vehicle;
import org.implementaciondb.vehiculos_siniestros.model.projections.VehicleProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT DISTINCT v.patent FROM Vehicle v")
    List<String> findPatents();

    @Query("SELECT v.patent as patent, v.brand as brand FROM Vehicle v ORDER BY v.manufactureYear")
    List<VehicleProjection> findPatentAndBrand();

    @Query("SELECT v.patent FROM Vehicle v WHERE v.numberOfWheels > 4 AND v.manufactureYear = YEAR(CURRENT_DATE)")
    List<String> findAllPatentsByNumberOfWheelsAndManufacturedYear();

    @Query("SELECT v.brand as brand, v.model as model, v.patent as patent FROM Vehicle v JOIN v.sinisters s WHERE s.economicLoss > 10000")
    List<VehicleProjection> findByEconomicLoss();

    @Query("SELECT v.brand as brand, v.model as model, v.patent as patent,  s.economicLoss as economicLoss  " +
            "FROM Vehicle v JOIN v.sinisters s WHERE s.economicLoss > 10000")
    List<VehicleProjection> getEconomicLossDetails();

}
