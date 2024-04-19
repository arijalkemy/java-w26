package org.ejercicio.conocesionaria.controller;

import org.ejercicio.conocesionaria.dto.VehicleDTO;
import org.ejercicio.conocesionaria.entity.Vehicle;
import org.ejercicio.conocesionaria.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(vehicleService.save(vehicle), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("dates")
    public ResponseEntity<List<VehicleDTO>> getAllVehiclesByDate(@RequestParam LocalDate since, @RequestParam LocalDate to) {
        return new ResponseEntity<>(vehicleService.getAllVehiclesByDate(since,to), HttpStatus.OK);
    }

    @GetMapping("prices")
    public ResponseEntity<List<VehicleDTO>> getAllVehiclesByPrices(@RequestParam double since, @RequestParam double to) {
        return new ResponseEntity<>(vehicleService.getAllVehiclesByPrices(since,to), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable UUID id) {
        return new ResponseEntity<>(vehicleService.findById(id), HttpStatus.OK);
    }
}
