package com.spring.concesionaria.controller;

import com.spring.concesionaria.dto.VehicleDTO;
import com.spring.concesionaria.service.IVehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehiclesController {

    @Autowired
    IVehiclesService vehiclesService;

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        return ResponseEntity.ok().body(vehiclesService.findAll());
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        try {
            this.vehiclesService.create(vehicleDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println("Error en createVehicle: " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> getAllVehiclesByDate(@RequestParam String since, @RequestParam String to) {
        return ResponseEntity.ok().body(vehiclesService.findBetweenDates(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> getAllVehiclesByPrice(@RequestParam String since, @RequestParam String to) {
        return ResponseEntity.ok().body(vehiclesService.findBetweenPrices(since, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable int id) {
        return ResponseEntity.ok().body(vehiclesService.findById(id));
    }

}
