package com.ej2p2dia3spring.carsdealership.service;

import com.ej2p2dia3spring.carsdealership.dto.VehicleDTO;

import java.util.List;

public interface IVehicleService {
    void addVehicle(VehicleDTO vehicleDTO);
    List<VehicleDTO> getAllVehicles();
    List<VehicleDTO> getVehiclesByManufacturingDate(String fromDate, String toDate);
    List<VehicleDTO> getVehiclesByPrice(int minPrice, int maxPrice);
    VehicleDTO getVehicleById(int id);
}
