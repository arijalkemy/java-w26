package com.aseguradora.repository;


import com.aseguradora.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    @Query("SELECT v.licensePlate FROM Vehicle v")
    List<String> findAllVehiclesLicensePlates();

    @Query("select v.licensePlate, v.brand from Vehicle v order by v.manufactureYear ASC")
    List<Vehicle> findVehiclesLicensePlateAndBrandByYearFabrication();

    @Query("select v.licensePlate from Vehicle v " +
            "where v.wheelCount > 4 " +
            "and YEAR(v.manufactureYear)  = year(CURRENT_DATE )")
    List<String> findLicensePlateByCarWithMoreThanFourWheelsFabricatedInCurrentYear();

}
