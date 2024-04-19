package org.ejercicio.conocesionaria.service;

import org.ejercicio.conocesionaria.dto.VehicleDTO;
import org.ejercicio.conocesionaria.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IVehicleService {
    VehicleDTO findById(UUID id);
    Vehicle save(Vehicle vehicle);
    List<VehicleDTO> getAllVehicles();
    List<VehicleDTO> getAllVehiclesByDate(LocalDate since, LocalDate to);
    List<VehicleDTO> getAllVehiclesByPrices(double since,double to);
    List<VehicleDTO> getAllVehiclesByOwners();
}
