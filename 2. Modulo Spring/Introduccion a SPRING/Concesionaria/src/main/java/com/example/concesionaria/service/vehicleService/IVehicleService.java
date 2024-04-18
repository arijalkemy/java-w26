package com.example.concesionaria.service.vehicleService;

import com.example.concesionaria.dto.VehicleDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IVehicleService {
    void createVehicle(VehicleDto vehicleDto);
    List<VehicleDto> getAllVehicles();
    List<VehicleDto> getAllVehiclesByDate(String since, String to);
    List<VehicleDto> getAllVehiclesByPrice(Double since, Double to);
    Optional<VehicleDto> getVehicleById(UUID id);
}
