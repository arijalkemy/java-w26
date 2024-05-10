package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.AvgSpeedDTO;
import com.bootcampW22.EjercicioGlobal.dto.MaxSpeedDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    Vehicle addVehicle(Vehicle v);

    Optional<Vehicle> findVehicleById(Long id);

    List<Vehicle> findVehicleByColorAndYear(String color, int year);

    List<Vehicle> findVehiclesByBrandAndRangeOfYears(String brand, int start_year, int end_year);

    List<Vehicle> findVehiclesByBrand(String brand);

    List<Vehicle> findVehicleByFuelType(String fuel_type);

    List<Vehicle> addVehicles(List<Vehicle> listVehicles);

    Vehicle updateVehicle(Vehicle vehicleToUpdate);

    Vehicle deleteVehicle(Vehicle vehicleToDelete);

    List<Vehicle> findVehiclesByTransmission(String transmission);

    List<Vehicle> findVehiclesByDimenssions(double min_length, double max_length, double min_width, double max_width );

    List<Vehicle> findVehiclesByWeightRange(double min,double max);
}
