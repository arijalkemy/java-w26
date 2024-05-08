package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    void createVehicle(VehicleDto vehicleDto);

    ResponseEntity<?> deleteVehicle(Long id);

    ResponseEntity<?> getVehicleByColorAndAge(String color, int year);

    ResponseEntity<?> getVehicleByBrandAndAgeRange(String brand, int sinceYear, int toYear);

    ResponseEntity<?> getVehicleAverageByBrand(String brand);

    ResponseEntity<?> createVehicles(List<VehicleDto> vehicles);

    ResponseEntity<?> updateSpeedById(Long id);
    ResponseEntity<?> getVehiclesByFuelType(String fuelType);

    ResponseEntity<?> getVehiclesByTransmission(String transmission);

    ResponseEntity<?> updateByTrasmission(Long id);

    ResponseEntity<?> getVehicleById(Long id);

    ResponseEntity<?> getAverageOfBrandCapacity(String brand);

    ResponseEntity<?> getVehicleByWeight(Double weight_min,Double weight_max);
}
