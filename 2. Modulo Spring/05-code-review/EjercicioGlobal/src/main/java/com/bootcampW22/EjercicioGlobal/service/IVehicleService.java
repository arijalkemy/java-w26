package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    String createVehicle(VehicleDto vehicleDto);

    List<VehicleDto> getVehiclesByColorAndYear(String color, int year);

    List<VehicleDto> getVehiclesByBrandAndYearRange(String brand, int startYear, int endYear);

    String getAverageSpeedByBrand(String brand);

    String createMultipleVehicles(List<VehicleDto> vehicles);

    String updateVehicleMaxSpeed(int id, VehicleDto vehicleDto);

    List<VehicleDto> getVehiclesByFuelType(String fuelType);

    String deleteVehicle(int id);

    List<VehicleDto> getVehiclesByTransmissionType(String type);

    String updatedVehicleFuelType(int id, VehicleDto vehicleDto);

    Double getVehicleAverageCapacityByBrand(String brand);

    List<VehicleDto> getVehiclesByDimensions(double minLength, double maxLength, double minWidth, double maxWidth);

    List<VehicleDto> getVehiclesByWeightRange(double minWeight, double maxWeight);
}
