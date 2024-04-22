package org.ejercicio.conocesionaria.controller;

import org.ejercicio.conocesionaria.dto.VehicleRequestDTO;
import org.ejercicio.conocesionaria.dto.VehicleResponseDTO;
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
@RequestMapping("vehicles")
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> addVehicle(@RequestBody VehicleRequestDTO vehicle) {
        return new ResponseEntity<>(vehicleService.addVechile(vehicle), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> getAllUsedVehicles() {
        return new ResponseEntity<>(vehicleService.getAllUsedVehicles(), HttpStatus.OK);
    }

    @GetMapping("dates")
    public ResponseEntity<List<VehicleResponseDTO>> getAllVehiclesByDate(@RequestParam LocalDate since, @RequestParam LocalDate to) {
        return new ResponseEntity<>(vehicleService.getAllVehiclesByDate(since,to), HttpStatus.OK);
    }

    @GetMapping("prices")
    public ResponseEntity<List<VehicleResponseDTO>> getAllVehiclesByPrices(@RequestParam double since, @RequestParam double to) {
        return new ResponseEntity<>(vehicleService.getAllVehiclesByPrices(since,to), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<VehicleResponseDTO> getVehicleById(@PathVariable UUID id) {
        return new ResponseEntity<>(vehicleService.findById(id), HttpStatus.OK);
    }
}
