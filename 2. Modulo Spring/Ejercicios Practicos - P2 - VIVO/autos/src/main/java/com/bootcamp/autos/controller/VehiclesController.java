package com.bootcamp.autos.controller;

import com.bootcamp.autos.dto.VehicleDTO;
import com.bootcamp.autos.entity.Vehicle;
import com.bootcamp.autos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehiclesController {

    @Autowired
    IVehicleService vehicleService;

    @PostMapping("/")
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.ok(vehicleService.save(vehicleDTO));
    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleDTO>> getVehicles() {
        return ResponseEntity.ok(vehicleService.findAll());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByProductionDate(@RequestParam String since, @RequestParam String to) {
        return ResponseEntity.ok(vehicleService.findByProductionDate(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByPrice(@RequestParam String since, @RequestParam String to) {
        return ResponseEntity.ok(vehicleService.findByPrice(Double.parseDouble(since), Double.parseDouble(to)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.findById(id));
    }
}
