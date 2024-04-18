package com.example.concesionaria.service;

import com.example.concesionaria.dto.VehicleRequestDto;
import com.example.concesionaria.dto.VehicleResponseDto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IVehicleService {
    UUID createVehicle(VehicleRequestDto vehicleDto);
    VehicleResponseDto getVehicle(UUID id);
    List<VehicleResponseDto> getVehicles();
    List<VehicleResponseDto> getVehiclesByDate(LocalDate since, LocalDate to);
    List<VehicleResponseDto> getVehiclesByPrice(Double since, Double to);
}
