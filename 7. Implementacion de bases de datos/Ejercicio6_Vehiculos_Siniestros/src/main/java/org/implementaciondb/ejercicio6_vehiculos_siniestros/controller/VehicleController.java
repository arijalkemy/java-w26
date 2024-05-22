package org.implementaciondb.ejercicio6_vehiculos_siniestros.controller;

import jakarta.validation.Valid;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.vehicle.*;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.service.interfaces.IVehicleService;
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
    private ResponseEntity<VehicleWithSinistersDto>getAllVehicles(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findVehicleById(id));
    }

    @GetMapping("/patents")
    private ResponseEntity<List<PatentDto>> getAllPatents() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllPatents());
    }

    @GetMapping("/patents-and-brands")
    private ResponseEntity<List<PatentAndBrandDto>> getAllPatentsAndBrands() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findPatentAndBrand());
    }

    @GetMapping("/patents/number-of-wheels/manufactured-year")
    private ResponseEntity<List<PatentDto>> getAllPatentsByWheelsAndYear() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vehicleService.findAllPatentsByNumberOfWheelsAndManufacturedYear());
    }

    @GetMapping("/economic-loss")
    private ResponseEntity<List<PartialVehicleDto>> getPartialVehicleByEconomicLoss() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findByEconomicLoss());
    }

    @GetMapping("/economic-loss/details")
    private ResponseEntity<List<PartialVehicleAndEconomicLossDto>> getPartialVehicleByEconomicLossAndDetails() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findByEconomicLossDetails());
    }

}
