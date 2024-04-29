package org.bootcamp.vehicles.controller;

import org.bootcamp.vehicles.dto.VehicleDTO;
import org.bootcamp.vehicles.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/")
    public ResponseEntity<VehicleDTO> save(@RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.ok(vehicleService.save(vehicleDTO));
    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleDTO>> getAll() {
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> getVehiclesBetweenManufacturingDates(@RequestParam LocalDate since, @RequestParam LocalDate to) {
        return ResponseEntity.ok(vehicleService.getVehiclesByManufacturingDate(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> getVehiclesBetweenPrices(@RequestParam Double since, @RequestParam Double to) {
        return ResponseEntity.ok(vehicleService.getVehiclesBetweenPrice(since, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

}
