package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleRequestDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleResponseDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

     Optional<Vehicle> createVehicle(VehicleRequestDto vehicleRequestDto);

    VehicleResponseDto getVehicleBy(String color, Integer year);

    ResponseEntity<?> deleteVehicle(Long id);

    ResponseEntity<?> getByBrand(String brand);
}
