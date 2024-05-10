package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    // Ejercicio 1
    void saveVehicle(VehicleDto vehicleDto);
    // Ejercicio 2
    List<Vehicle> searchByColorAndYear(String color, int year);

    // Ejercicio 3
    List<Vehicle> searchByBrandAndYearRange(String brand, int start_year, int end_year);

    // Ejercicio 4
    int getAvgSpeedByBrand(String brand);

    // Ejercicio 5
    List<Vehicle> saveVehicleBatch(List<VehicleDto> vehicleDto);

    // Ejercicio 6
    Optional<Vehicle> findById(Long id);

    // Ejercicio 7
    List<Vehicle> searchByFuel(String type);

    // Ejercicio 8
    void deleteById(Long id);

    // Ejercicio 9
    List<Vehicle> searchByTransmission(String type);

    // Ejercicio 11
    Double getAvgByBrand(String brand);

    // Ejercicio 12
    List<Vehicle> searchByDimensions(String length, String width);

    // Ejercicio 13
    List<Vehicle> searchByWeightRange(double min, double max);
}
