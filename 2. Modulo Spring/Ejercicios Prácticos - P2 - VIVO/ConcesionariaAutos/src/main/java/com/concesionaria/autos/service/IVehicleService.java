package com.concesionaria.autos.service;

import com.concesionaria.autos.dto.VehicleDTO;
import com.concesionaria.autos.entity.Vehicle;

import java.util.List;


public interface IVehicleService {
    VehicleDTO createVehicle(VehicleDTO vehicleDTO);
    List<VehicleDTO> getAllVehicles();
    List<VehicleDTO> getVehiclesByDate(String sinceDate, String toDate);
    List<VehicleDTO> getVehiclesByPrice(Double min, Double max);
    VehicleDTO getVehicleById(int id);
}
