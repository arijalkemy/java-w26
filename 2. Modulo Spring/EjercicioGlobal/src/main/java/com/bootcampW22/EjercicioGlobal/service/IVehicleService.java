package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    // Ejercicio 1
    VehicleDto postNewVehicles(VehicleDto vehicleDto);

    // Ejercicio 2
    List<VehicleDto> getVehiclesByColorAndYear(String color, int year);

    // Ejercicio 3
    List<VehicleDto> getVehiclesByBrandAndYearRange(String brand, int start_year, int end_year);

    // Ejercicio 4
    int getAvgSpeedByBrand(String brand);

    // Ejercicio 5
    List<VehicleDto> postVehicleBatch(List<VehicleDto> vehicleDto);

    // Ejercicio 6
    VehicleDto changeSpeedById(Long id, String max_speed);

    // Ejercicio 7
    List<VehicleDto> getVehiclesByFuel(String type);

    // Ejercicio 8
    String deleteById(Long id);

    // Ejercicio 9
    List<VehicleDto> getByTransmission(String type);

    // Ejercicio 10
    VehicleDto changeFuelType(Long id, String fuel_type);

    // Ejercicio 11
    Double getAvgByBrand(String brand);

    // Ejercicio 12
    List<VehicleDto> getDimensions(String length, String width);

    // Ejercicio 13
    List<VehicleDto> getVehiclesByWeightRange(double min, double max);
}
