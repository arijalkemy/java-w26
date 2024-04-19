package org.example.concesionaria.controller;

import org.example.concesionaria.dto.VehicleCompleteDTO;
import org.example.concesionaria.dto.VehiclePostRequestDTO;
import org.example.concesionaria.dto.VehicleWithoutServicesDTO;
import org.example.concesionaria.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;


    @GetMapping
    public ResponseEntity<List<VehicleWithoutServicesDTO>> getAll() {
        return ResponseEntity.ok(vehicleService.findAll());
    }

    @PostMapping
    public ResponseEntity<VehicleCompleteDTO> create(@RequestBody VehiclePostRequestDTO vehiclePostRequestDTO) {
        return ResponseEntity.ok(vehicleService.create(vehiclePostRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleCompleteDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(vehicleService.findById(id).orElse(null));
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleCompleteDTO>> findByManufacturingDate(
        @RequestParam LocalDate since,
        @RequestParam LocalDate to
    ) {
        return ResponseEntity.ok(vehicleService.findByManufacturingDate(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleCompleteDTO>> findByPrice(
        @RequestParam Integer since,
        @RequestParam Integer to
    ) {
        return ResponseEntity.ok(vehicleService.findByPrice(since, to));
    }
}
