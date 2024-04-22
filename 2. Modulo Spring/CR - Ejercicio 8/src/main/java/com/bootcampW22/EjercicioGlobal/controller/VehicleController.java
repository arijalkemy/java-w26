package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>( vehicleService.createVehicle(vehicle), HttpStatus.CREATED );
    }

    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAvgCapacityPerBrand(@PathVariable String brand ){
        return new ResponseEntity<>( vehicleService.avgCapacityPerBrand(brand), HttpStatus.OK );
    }

    @GetMapping("/vehicles/brand/{brand}/between/{startYear}/{endYear}")
    public ResponseEntity<?> getAvgCapacityPerBrand(@PathVariable String brand, @PathVariable int startYear, @PathVariable int endYear ){
        return new ResponseEntity<>( vehicleService.searchByBrandAndYear(brand, startYear, endYear), HttpStatus.OK );
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateMaxSpeed(@PathVariable long id, @RequestBody Vehicle vehicle ){
        return new ResponseEntity<>( vehicleService.updateMaxSpedVehicle( id, vehicle ), HttpStatus.OK );
    }
}
