package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }
    @GetMapping("/ ")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    //Ejercicio 1
    @PostMapping("/createVehicle")
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDto vehicleDto){
        vehicleService.createVehicle(vehicleDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Ejercicio 2
    @GetMapping("/getVehicleByColorAndAge")
    public ResponseEntity<?> getVehicleByColorAndAge(@RequestParam String color, @RequestParam int year){
        return vehicleService.getVehicleByColorAndAge(color, year);
    }

    // Ejercicio 3
    @GetMapping("getVehicleByBrandAndAgeRange")
    public ResponseEntity<?> getVehicleByBrandAndAgeRange(@RequestParam String brand,
                                                          @RequestParam int sinceYear, int toYear){
        return vehicleService.getVehicleByBrandAndAgeRange(brand, sinceYear, toYear);
    }

    // Ejercicio 4
    @GetMapping("getVehicleAverageByBrand")
    public ResponseEntity<?> getVehicleAverageByBrand(@RequestParam String brand){
        return vehicleService.getVehicleAverageByBrand(brand);
    }

    //Ejercicio 5
    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> createVehicles(@RequestBody List<VehicleDto> vehicles){
        return vehicleService.createVehicles(vehicles);
    }

    // Ejercicio 6
    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpeedById(@PathVariable Long id){
        return vehicleService.updateSpeedById(id);
    }

    //Ejercicio 7
    @GetMapping("/vehicles/fuel_type/{fuel_type}")
    public ResponseEntity<?> getVehiclesByFuelType(@PathVariable String fuel_type){
        return vehicleService.getVehiclesByFuelType(fuel_type);
    }

    // Ejercicio 8
    @DeleteMapping("/deleteVehicle/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return vehicleService.deleteVehicle(id);
    }

    // Ejercicio 9
    @GetMapping("vehicles/transmission/{transmission}")
    public ResponseEntity<?> getVehiclesByTransmission (@PathVariable String transmission){
        return vehicleService.getVehiclesByTransmission(transmission);
    }

    // Ejercicio 10
    @PutMapping("/vehicles/{id}/transmission")
    public ResponseEntity<?> updateByTrasmission(@PathVariable Long id){
        return vehicleService.updateByTrasmission(id);
    }

    // Endpoint Auxiliar para testear manualmente que los puts hayan impactado correctamente
    @GetMapping("vehicles/getVehicleById/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable Long id){
        return vehicleService.getVehicleById(id);
    }

    // Ejercicio 11
    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAverageOfBrandCapacity(@PathVariable String brand){
        return vehicleService.getAverageOfBrandCapacity(brand);
    }

    // Ejercicio 13
    @GetMapping("/vehicles/weight?min={weight_min}&max={weight_max}")
    public ResponseEntity<?> getVehicleByWeight(@RequestParam Double weight_min, @RequestParam Double weight_max ){
        return vehicleService.getVehicleByWeight(weight_min, weight_max);
    }


}
