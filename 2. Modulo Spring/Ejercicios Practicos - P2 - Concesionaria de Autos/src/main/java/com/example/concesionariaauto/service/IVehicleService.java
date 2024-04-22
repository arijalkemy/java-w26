package com.example.concesionariaauto.service;

import com.example.concesionariaauto.dto.VehicleAllResponseDTO;
import com.example.concesionariaauto.dto.VehicleRequestDTO;
import com.example.concesionariaauto.dto.VehicleResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IVehicleService {
    VehicleResponseDTO addVehicle(VehicleRequestDTO vehicle);
    List<VehicleResponseDTO> listVehicle();
    List<VehicleResponseDTO> listVehicleFromManufacturingDate(LocalDate since, LocalDate to);
    List<VehicleResponseDTO> listVehicleFromPrice(int since, int to);
    VehicleAllResponseDTO getVehicleById(UUID id);
}
