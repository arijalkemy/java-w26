package com.mercadolibre.ConcecionariaAutos.controller;

import com.mercadolibre.ConcecionariaAutos.dto.VehicleDTO;
import com.mercadolibre.ConcecionariaAutos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles/")
public class VehicleController {

    @Autowired
    IVehicleService vehicleService;

    @PostMapping
    public ResponseEntity<Boolean> saveVehicle(@RequestBody VehicleDTO vehicleDTO){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.postVehicle(vehicleDTO));
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles(){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllVehicles());
    }

    @GetMapping("dates")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByDate(@RequestParam LocalDate since, @RequestParam LocalDate to){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehiclesByManufacturingDate(since,to));
    }

    @GetMapping("prices")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByPrice(@RequestParam double since, @RequestParam double to){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehiclesByPrice(since,to));
    }

    @GetMapping("{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicleById(id));
    }
}
