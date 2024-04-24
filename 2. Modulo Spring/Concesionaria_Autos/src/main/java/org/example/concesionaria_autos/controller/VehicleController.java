package org.example.concesionaria_autos.controller;

import org.example.concesionaria_autos.entity.Vehicle;
import org.example.concesionaria_autos.dto.VehicleDto;
import org.example.concesionaria_autos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api")
public class VehicleController {
    @Autowired
    IVehicleService vehicleService;


    @PostMapping("/vehicles")
    public ResponseEntity<String> addNewVehicle(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.addNewVehicle(vehicle), HttpStatus.OK);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        return new ResponseEntity<>(vehicleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable int id) {
        return new ResponseEntity<>(vehicleService.getVehicleById(id), HttpStatus.OK);
    }

    @GetMapping("vehicles/prices")
    public ResponseEntity<List<VehicleDto>> findVehiclesByPrice(@RequestParam int since, @RequestParam int to) {
        return new ResponseEntity<>(vehicleService.getVehicleByPrice(since, to), HttpStatus.OK);
    }

    @GetMapping ("vehicles/dates")
    public ResponseEntity<List<VehicleDto>> getVehiclesByDate(@RequestParam String since, @RequestParam String to) {
        return new ResponseEntity<>(vehicleService.getVehiclesByDate(since, to), HttpStatus.OK);
    }


}
