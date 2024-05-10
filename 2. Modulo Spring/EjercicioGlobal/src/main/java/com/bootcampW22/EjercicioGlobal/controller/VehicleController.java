package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles() {
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    // Ejercicio 1
    @PostMapping("/vehicles")
    public ResponseEntity<?> postNewVehicle(@RequestBody VehicleDto vehicleDto) {
        return new ResponseEntity<>(this.vehicleService.postNewVehicles(vehicleDto), HttpStatus.CREATED);
    }

    // Ejercicio 2
    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> getVehiclesByColorAndYear(@PathVariable String color, @PathVariable int year) {
        return new ResponseEntity<>(this.vehicleService.getVehiclesByColorAndYear(color, year), HttpStatus.OK);
    }

    // Ejercicio 3
    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> getVehiclesByBrandAndYearRange(@PathVariable String brand, @PathVariable int start_year, @PathVariable int end_year) {
        return new ResponseEntity<>(this.vehicleService.getVehiclesByBrandAndYearRange(brand, start_year, end_year), HttpStatus.OK);
    }

    // Ejercicio 4
    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> getAvgSpeedByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(this.vehicleService.getAvgSpeedByBrand(brand), HttpStatus.OK);
    }

    // Ejercicio 5
    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> postVehicleBatch(@RequestBody List<VehicleDto> vehicleDto) {
        return new ResponseEntity<>(this.vehicleService.postVehicleBatch(vehicleDto), HttpStatus.CREATED);
    }

    // Ejercicio 6
    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> changeSpeedById(@PathVariable Long id, @RequestParam String max_speed) {
        return new ResponseEntity<>(this.vehicleService.changeSpeedById(id, max_speed), HttpStatus.OK);
    }

    // Ejercicio 7
    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> getVehiclesByFuel(@PathVariable String type) {
        return new ResponseEntity<>(this.vehicleService.getVehiclesByFuel(type), HttpStatus.OK);
    }

    // Ejercicio 8
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(this.vehicleService.deleteById(id), HttpStatus.OK);
    }

    // Ejercicio 9
    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<?> getByTransmission(@PathVariable String type) {
        return new ResponseEntity<>(this.vehicleService.getByTransmission(type), HttpStatus.OK);
    }

    // Ejercicio 10
    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<?> changeFuelType(@PathVariable Long id, @RequestParam String fuel_type) {
        return new ResponseEntity<>(this.vehicleService.changeFuelType(id, fuel_type), HttpStatus.OK);
    }

    // Ejercicio 11
    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAvgByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(this.vehicleService.getAvgByBrand(brand), HttpStatus.OK);
    }

    // Ejercicio 12
    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> getDimensions(@RequestParam String length, @RequestParam String width) {
        return new ResponseEntity<>(this.vehicleService.getDimensions(length, width), HttpStatus.OK);
    }

    // Ejercicio 13
    @GetMapping("/vehicles/weight")
    public ResponseEntity<?> getVehiclesByWeightRange(@RequestParam double min, @RequestParam double max) {
        return new ResponseEntity<>(this.vehicleService.getVehiclesByWeightRange(min, max), HttpStatus.OK);
    }
}
