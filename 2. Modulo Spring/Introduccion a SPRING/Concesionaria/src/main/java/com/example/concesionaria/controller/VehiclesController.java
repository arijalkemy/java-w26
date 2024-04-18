package com.example.concesionaria.controller;

import com.example.concesionaria.dto.VehicleDto;
import com.example.concesionaria.service.vehicleService.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehiclesController {

    @Autowired
    IVehicleService vehicleService;

    @PostMapping
    public ResponseEntity<String> createVehicle(@RequestBody VehicleDto vehicleDto){
        vehicleService.createVehicle(vehicleDto);
        return new ResponseEntity<>("Vehiculo creado con éxito", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getAllVehicles(){
        List<VehicleDto> vehicleDtos = vehicleService.getAllVehicles();
        return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDto>> getAllVehiclesByDate(@RequestParam String since,
                                                                        @RequestParam String to){
        List<VehicleDto> vehicleDtos = vehicleService.getAllVehiclesByDate(since, to);
        return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDto>> getAllVehiclesByPrice(@RequestParam Double since,
                                                                  @RequestParam Double to){
        List<VehicleDto> vehicleDtos = vehicleService.getAllVehiclesByPrice(since, to);
        return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<VehicleDto>> getAllVehiclesById(@PathVariable UUID id){
        Optional<VehicleDto> vehicleDto = vehicleService.getVehicleById(id);
        return new ResponseEntity<>(vehicleDto, HttpStatus.OK);
    }

}
