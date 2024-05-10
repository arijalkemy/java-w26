package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.FuelTypeDto;
import com.bootcampW22.EjercicioGlobal.dto.MaxSpeedDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles() {
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> postVehicle(@RequestBody Vehicle v) {
        return new ResponseEntity<>(vehicleService.addNewVehicle(v), HttpStatus.CREATED);
    }

    @GetMapping("vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> getVehiclesByColorAndYear(@PathVariable String color, @PathVariable int year) {
        return new ResponseEntity<>(vehicleService.findVehicleByColorAndYear(color, year), HttpStatus.OK);
    }

    @GetMapping("vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> getVehiclesByBrandAndRangeOfYears(@PathVariable String brand,
                                                               @PathVariable int start_year,
                                                               @PathVariable int end_year) {
        return new ResponseEntity<>(vehicleService.findVehiclesByBrandAndRangeOfYears(brand, start_year, end_year), HttpStatus.OK);
    }

    @GetMapping("vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> getSpeedAvgByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.calculateSpeedAvgByBrand(brand), HttpStatus.OK);
    }

    @PostMapping("vehicles/batch")
    public ResponseEntity<?> postVehiclesList(@RequestBody List<Vehicle> vehicleList) {
        return new ResponseEntity<>(vehicleService.addVehicles(vehicleList), HttpStatus.OK);
    }

    @PutMapping("vehicles/{id}/update_speed")
    public ResponseEntity<?> updateVehicleMaxSpeed(@RequestBody MaxSpeedDto maxSpeed, @PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.updateMaxSpeed(id, maxSpeed), HttpStatus.OK);
    }

    @GetMapping("vehicles/fuel_type/{type}")
    public ResponseEntity<?> findVehicleByFuelType(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.findVehiclesByFuelType(type), HttpStatus.OK);
    }

    @DeleteMapping("vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.deleteVehicle(id),HttpStatus.OK);
    }

    @GetMapping("vehicles/transmission/{transmission}")
    public ResponseEntity<?> getVehiclesByTransmission(@PathVariable String transmission){
        return  new ResponseEntity<>(vehicleService.findVehiclesByTransmission(transmission),HttpStatus.OK);
    }

    @PutMapping("vehicles/{id}/update_fuel")
    public ResponseEntity<?> updateFuelType(@PathVariable Long id, @RequestBody FuelTypeDto fuelType){
        return new ResponseEntity<>(vehicleService.updateFuelType(id,fuelType),HttpStatus.OK);
    }

    @GetMapping("vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAvgCapacityByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.calculateAvgCapacityByBrand(brand),HttpStatus.OK);
    }

    @GetMapping("vehicles/dimensions")
    public ResponseEntity<?> getVehiclesByDimenssions(@RequestParam String length, @RequestParam String width){
        return new ResponseEntity<>(
                vehicleService.findVehiclesByDimenssions(length,width),
                HttpStatus.OK);
    }

    @GetMapping("vehicles/weight")
    public ResponseEntity<?> getVehiclesByWeightRange(@RequestParam double min,@RequestParam double max){
        return new ResponseEntity<>(vehicleService.findVehiclesByWeightRange(min,max),HttpStatus.OK);
    }


}
