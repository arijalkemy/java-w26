package com.spring.concesionaria.services;

import com.spring.concesionaria.dtos.VehicleCreationDTO;
import com.spring.concesionaria.dtos.VehicleResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {
    VehicleCreationDTO addVehicle(VehicleCreationDTO vehicleCreationDTO);
    List<VehicleResponseDTO> getAllVehicles();
    List<VehicleResponseDTO> getSinceDate(LocalDate sinceDate);
    List<VehicleResponseDTO> getSincePrice(double sincePrice);
    VehicleCreationDTO getById(Long id);
}
