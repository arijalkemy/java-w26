package org.ejercicio.conocesionaria.service;

import org.ejercicio.conocesionaria.dto.VehicleRequestDTO;
import org.ejercicio.conocesionaria.dto.VehicleResponseDTO;
import org.ejercicio.conocesionaria.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IVehicleService {
    VehicleResponseDTO findById(UUID id);
    VehicleResponseDTO addVechile(VehicleRequestDTO vehicleRequestDTO);
    List<VehicleResponseDTO> getAllUsedVehicles();
    List<VehicleResponseDTO> getAllVehiclesByDate(LocalDate since, LocalDate to);
    List<VehicleResponseDTO> getAllVehiclesByPrices(double since, double to);
}
