package org.example.concesionaria.service;

import org.example.concesionaria.dto.VehicleCompleteDTO;
import org.example.concesionaria.dto.VehiclePostRequestDTO;
import org.example.concesionaria.dto.VehicleWithoutServicesDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IVehicleService {
    List<VehicleWithoutServicesDTO> findAll();
    Optional<VehicleCompleteDTO> findById(UUID id);
    VehicleCompleteDTO create(VehiclePostRequestDTO vehiclePostRequestDTO);
    List<VehicleCompleteDTO> findByManufacturingDate(LocalDate since, LocalDate to);
    List<VehicleCompleteDTO> findByPrice(Integer since, Integer to);
}
