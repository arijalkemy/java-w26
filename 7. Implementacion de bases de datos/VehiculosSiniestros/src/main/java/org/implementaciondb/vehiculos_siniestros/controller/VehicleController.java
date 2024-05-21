package org.implementaciondb.vehiculos_siniestros.controller;

import jakarta.validation.Valid;
import org.implementaciondb.vehiculos_siniestros.model.dto.vehicle.VehicleRequestDto;
import org.implementaciondb.vehiculos_siniestros.model.dto.vehicle.VehicleResponseDto;
import org.implementaciondb.vehiculos_siniestros.model.dto.vehicle.VehicleWithSinistersDto;
import org.implementaciondb.vehiculos_siniestros.service.interfaces.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

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
    private ResponseEntity<VehicleWithSinistersDto> FindVehicleById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findVehicleById(id));
    }

    @GetMapping("/patents")
    private ResponseEntity<?> getAllPatents() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllPatents());
    }

    @GetMapping("/patentAndBrand")
    private ResponseEntity<?> getPatentAndBrand() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findPatentAndBrand());
    }

    @GetMapping("/patentsByNumberOfWheelsAndManufacturedYear")
    private ResponseEntity<?> getPatentsByNumberOfWheelsAndManufacturedYear() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findAllPatentsByNumberOfWheelsAndManufacturedYear());
    }

    @GetMapping("/LossMoreThan10000")
    private ResponseEntity<?> getEconomicLoss() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getLostMoreThan10000());
    }

    @GetMapping("/economicLossDetails")
    private ResponseEntity<?> getEconomicLossDetails() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getEconomicLossDetails());
    }

}
