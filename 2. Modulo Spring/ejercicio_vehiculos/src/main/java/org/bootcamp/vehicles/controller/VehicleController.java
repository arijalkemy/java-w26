package org.bootcamp.vehicles.controller;

import org.bootcamp.vehicles.dto.VehicleDTO;
import org.bootcamp.vehicles.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.ok(vehicleService.save(vehicleDTO));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getVehiclesBetweenManufacturingDates(@RequestParam LocalDate since, @RequestParam LocalDate to) {
        return ResponseEntity.ok(vehicleService.getVehiclesByManufacturingDate(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getVehiclesBetweenPrices(@RequestParam Double since, @RequestParam Double to) {
        return ResponseEntity.ok(vehicleService.getVehiclesBetweenPrice(since, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

}
