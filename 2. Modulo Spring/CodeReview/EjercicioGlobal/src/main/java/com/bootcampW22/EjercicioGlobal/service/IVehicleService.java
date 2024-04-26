package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    public void createVehicle(VehicleDto vehicleDto);

    public List<VehicleDto> getVehiclesByColorAndYear(String color, String year);

    public List<VehicleDto> getVehiclesByColorAndYearRange(String color, String since, String to);

    public AverageResponseDto getAverageSpeedByBrand(String brand);

    public void createVehicles(List<VehicleDto> vehicleDtos);

    public void updateMaxSpeed(String id, String maxSpeed);

    public List<VehicleDto> getVehiclesByFuelType(String fuelType);

    public void deleteVehicle(String id);

    public List<VehicleDto> getVehiclesByTransmissionType(String type);

    public void updateFuelType(String id, String type);

    public AverageResponseDto getAverageCapacityByBrand(String brand);

    public List<VehicleDto> getVehiclesByDimensions(
            String minLength, String maxLength, String minWidth, String maxWidth
    );

    public List<VehicleDto> getVehiclesByWeightRange(String minWeight, String maxWeight);
}
