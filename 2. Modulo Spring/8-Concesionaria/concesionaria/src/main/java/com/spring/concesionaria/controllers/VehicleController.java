package com.spring.concesionaria.controllers;

import com.spring.concesionaria.dtos.VehicleCreationDTO;
import com.spring.concesionaria.dtos.VehicleResponseDTO;
import com.spring.concesionaria.services.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
    private IVehicleService vehicleService;
    public VehicleController(IVehicleService service){
        vehicleService = service;
    }

    @PostMapping
    public ResponseEntity<VehicleCreationDTO> postVehicle(@RequestBody VehicleCreationDTO vehicleCreationDTO){
        return ResponseEntity.ok(vehicleService.addVehicle(vehicleCreationDTO));
    }
    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> getAllVehicles(){
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }
    @GetMapping("dates")
    public ResponseEntity<List<VehicleResponseDTO>> geySinceDate(@RequestParam LocalDate since){
        return ResponseEntity.ok(vehicleService.getSinceDate(since));
    }
    @GetMapping("price")
    public ResponseEntity<List<VehicleResponseDTO>> geySincePrice(@RequestParam double since){
        return ResponseEntity.ok(vehicleService.getSincePrice(since));
    }
    @GetMapping("/{id}")
    public ResponseEntity<VehicleCreationDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.getById(id));
    }
}
