package meli.bootcamp.concesionaria.controller;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.concesionaria.dto.VehicleDto;
import meli.bootcamp.concesionaria.dto.VehicleServiceDto;
import meli.bootcamp.concesionaria.service.VehicleImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleImpl vehicleImpl;

    @PostMapping
    public ResponseEntity<List<VehicleServiceDto>> addVehicle(@RequestBody List<VehicleServiceDto> vehicle) {
        return ResponseEntity.ok(vehicleImpl.addVehicle(vehicle));
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        return ResponseEntity.ok(vehicleImpl.getVehicles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable Integer id) {
        return ResponseEntity.ok(vehicleImpl.getVehicleById(id));
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleServiceDto>> getVehiclesByDate(@RequestParam String since, @RequestParam String to) {
        return ResponseEntity.ok(vehicleImpl.getVehiclesFilterDate(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleServiceDto>> getVehiclesByPrice(@RequestParam Integer since, @RequestParam Integer to) {
        return ResponseEntity.ok(vehicleImpl.getVehiclesFilterPrice(since, to));
    }

}
