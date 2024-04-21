package org.ggomezr.concesionariaautos.application.controller;

import org.ggomezr.concesionariaautos.application.service.impl.VehicleService;
import org.ggomezr.concesionariaautos.domain.dto.VehicleInputDTO;
import org.ggomezr.concesionariaautos.domain.dto.VehicleResponseDTO;
import org.ggomezr.concesionariaautos.domain.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping()
    public ResponseEntity<?> createVehicle(@RequestBody VehicleInputDTO vehicle){
        return new ResponseEntity<>(vehicleService.createVehicle(vehicle), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllVehicles(){
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getVehiclesByManufacturingDate(@RequestParam LocalDate since, @RequestParam LocalDate to){
        return new ResponseEntity<>(vehicleService.getVehiclesByManufacturingDate(since, to), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getVehiclesByPriceRange(@RequestParam Integer since, @RequestParam Integer to){
        return new ResponseEntity<>(vehicleService.getVehiclesByPriceRange(since, to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable Integer id){
        return new ResponseEntity<>(vehicleService.getVehicleById(id), HttpStatus.OK);
    }
}
