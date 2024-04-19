package org.example.vehicles.controllers;

import org.example.vehicles.dto.VehicleEntryDto;
import org.example.vehicles.dto.VehicleExitDto;
import org.example.vehicles.entities.Vehicle;
import org.example.vehicles.services.IVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
    private final IVehicle iVehicle;

    public VehicleController(@Autowired IVehicle iVehicle) {
        this.iVehicle = iVehicle;
    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleExitDto>> getVehicles() {
        return ResponseEntity.ok(this.iVehicle.getVehicles());
    }

    @PostMapping("/")
    public ResponseEntity<String> postVehicle(@RequestBody VehicleEntryDto vehicle) {
        return ResponseEntity.ok(this.iVehicle.createVehicle(vehicle));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.iVehicle.getVehicleById(id));
    }

    @GetMapping("/dates")
    public ResponseEntity<List<Vehicle>> getVehicleRangeDate(@RequestParam String since, @RequestParam String to) {
        return ResponseEntity.ok(this.iVehicle.getVehiclesBetweenDates(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<Vehicle>> getVehiclePriceRange(@RequestParam Integer since, @RequestParam Integer to) {
        return ResponseEntity.ok(this.iVehicle.getVehiclesBetweenPrices(since, to));
    }
}
