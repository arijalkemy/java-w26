package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.*;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    ExceptionDto addNewVehicle(Vehicle v);

    List<VehicleDto> findVehicleByColorAndYear(String color, int year);

    List<VehicleDto> findVehiclesByBrandAndRangeOfYears(String brand, int start_year, int end_year);

    AvgSpeedDTO calculateSpeedAvgByBrand(String brand);

    ExceptionDto addVehicles(List<Vehicle> listVehicles);

    ExceptionDto updateMaxSpeed(Long id, MaxSpeedDto maxSpeed);

    List<VehicleDto> findVehiclesByFuelType(String fuel_type);

    ExceptionDto deleteVehicle(Long id);

    List<VehicleDto> findVehiclesByTransmission(String transmission);

    ExceptionDto updateFuelType(Long id, FuelTypeDto fuelType);

    AvgCapacityDto calculateAvgCapacityByBrand(String brand);

    List<VehicleDto> findVehiclesByDimenssions(String length, String width);

    List<VehicleDto> findVehiclesByWeightRange(double min, double max);
}

