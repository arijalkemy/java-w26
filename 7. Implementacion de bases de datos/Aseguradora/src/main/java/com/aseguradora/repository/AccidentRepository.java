package com.aseguradora.repository;

import com.aseguradora.entity.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidentRepository extends CrudRepository<Accident, Long> {

    @Query("select s.vehicle.licensePlate,s.vehicle.brand, s.vehicle.model" +
            " from Accident s " +
            "where s.economicLoss > 10000")
    List<String> findAllEconomicLoss();

    /*@Query("select SUM(s.economicLoss), s.vehicle.brand, s.vehicle.licensePlate, s.vehicle.model" +
            " from Accident s " +
            "where s.economicLoss > 10000" +
            " group by s.vehicle.licensePlate")
    List<String> findAllEconomicLossByLicensePlate();*/
    @Query("select SUM(s.economicLoss), s.vehicle.brand, s.vehicle.licensePlate, s.vehicle.model" +
            " from Accident s " +
            "where s.economicLoss > 10000" +
            " group by s.vehicle.licensePlate")
    List<String> findAllEconomicLossByLicensePlate();
    
}
