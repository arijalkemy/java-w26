package com.concesionaria.autos.controller;

import com.concesionaria.autos.dto.VehicleDTO;
import com.concesionaria.autos.service.IVehicleService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class VehicleController {
    @Autowired
    IVehicleService vehicleService;

    @PostMapping("/vehicles")
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return new ResponseEntity<>(vehicleService.createVehicle(vehicleDTO), HttpStatus.CREATED);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getAllVehicles() {
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("/vehicles/dates")
    public ResponseEntity<?> getVehiclesByDate(@PathParam("since") String since, @PathParam("to") String to) {
        return new ResponseEntity<>(vehicleService.getVehiclesByDate(since, to), HttpStatus.OK);
    }

    @GetMapping("/vehicles/prices")
    public ResponseEntity<?> getVehiclesByPrice(@PathParam("since") Double since, @PathParam("to") Double to) {
        return new ResponseEntity<>(vehicleService.getVehiclesByPrice(since, to), HttpStatus.OK);
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable int id) {
        return new ResponseEntity<>(vehicleService.getVehicleById(id), HttpStatus.OK);
    }
}
