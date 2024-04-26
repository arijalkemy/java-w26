package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.AlreadyExistsException;
import com.bootcampW22.EjercicioGlobal.exception.ValidationException;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    VehicleDto createVehicle(VehicleDto vehicleDto);

    List<VehicleDto> findVehiclesByColorAndYear(String color, int year);

    Double calculateAverageSpeedByBrand(String brand);

    List<VehicleDto> createVehicles(List<VehicleDto> vehicleDtos);

    void updateVehicleSpeed(Long id, int max_speed);

    List<VehicleDto> findVehiclesByFuelType(String fuelType);

    List<VehicleDto> findVehiclesByTransmission(String type);

    void deleteVehicle(Long id);

    List<VehicleDto> findVehiclesByDimensions(double min_length, double max_length, double min_width, double max_width);
}
