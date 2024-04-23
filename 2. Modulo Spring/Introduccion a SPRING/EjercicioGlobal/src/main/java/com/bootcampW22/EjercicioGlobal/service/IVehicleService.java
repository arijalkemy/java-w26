package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    void updateVehicleSpeed(Long id, String speed);
    void updateVehicleFuel(Long id, String fuelType);
    List<VehicleDto> searchAllVehicles();
    List<VehicleDto> searchAllVehiclesByColorAndYear(String color, int year);
    List<VehicleDto> searchAllVehiclesByBrandAndRangeOfYears(String brand, int start_year, int end_year);
    List<VehicleDto> searchAllVehiclesByFuelType(String type);
    List<VehicleDto> searchAllVehiclesByTransmissionType(String type);
    Double getMeanSpeedByBrand(String brand);
    Double getMeanCapacityByBrand(String brand);

    List<VehicleDto> searchAllVehiclesByDimensions(String length, String width);
    void createVehicle(VehicleDto vehicleDto);

    void deleteVehicle(Long id);
    void createVehiclesBatch(List<VehicleDto> vehicleDtos);
}
