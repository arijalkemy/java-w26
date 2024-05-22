package org.implementaciondb.ejercicio6_vehiculos_siniestros.controller;

import jakarta.validation.Valid;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.vehicle.VehicleRequestDto;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.vehicle.VehicleResponseDto;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.vehicle.VehicleWithSinistersDto;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.service.interfaces.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class  VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @PostMapping
    private ResponseEntity<VehicleResponseDto> createVehicle(@RequestBody @Valid VehicleRequestDto vehicleRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.saveVehicle(vehicleRequestDto));
    }

    @GetMapping
    private ResponseEntity<List<VehicleWithSinistersDto>> getAllVehicles() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findAllVehicles());
    }

    @GetMapping("/{id}")
    private ResponseEntity<VehicleWithSinistersDto>getAllVehicles(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findVehicleById(id));
    }

    @GetMapping("/prueba")
    private ResponseEntity<?> getPrueba() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllPatents());
    }

    @GetMapping("/patentBrand")
    private ResponseEntity<?> getPatentBrand() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findPatentAndBrand());
    }

}
