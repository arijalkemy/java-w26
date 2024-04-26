package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.ExceptionDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // ---------------- POST -------------

    @PostMapping("/vehicles")
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.createVehicle(vehicleDto), HttpStatus.CREATED);
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> createVehicles(@RequestBody List<VehicleDto> vehicleDtos) {
        List<VehicleDto> createdVehicles = vehicleService.createVehicles(vehicleDtos);
        return new ResponseEntity<>(createdVehicles, HttpStatus.CREATED);
    }

    // ---------------- GET SIMPLE (path variable) -------------

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> getVehiclesByColorAndYear(@PathVariable String color, @PathVariable int year) {

            List<VehicleDto> vehicles = vehicleService.findVehiclesByColorAndYear(color, year);
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageSpeedByBrand(@PathVariable String brand) {
        Double averageSpeed = vehicleService.calculateAverageSpeedByBrand(brand);
        return new ResponseEntity<>(averageSpeed.toString() + " km/h", HttpStatus.OK);
    }

    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByFuelType(@PathVariable("type") String type) {

        List<VehicleDto> vehicles = vehicleService.findVehiclesByFuelType(type);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);

    }

    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByç(@PathVariable("type") String type) {

        List<VehicleDto> vehicles = vehicleService.findVehiclesByTransmission(type);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    // ---------------- PUT -------------

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<String> updateVehicleSpeed(@PathVariable Long id, @RequestParam int max_speed) {
        vehicleService.updateVehicleSpeed(id, max_speed);
        return ResponseEntity.ok("Velocidad del vehículo actualizada exitosamente.");
    }

    // ---------------- DELETE -------------

    @DeleteMapping("/vehicles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }

    // ---------------- GET COMPLICATED (REQUEST PARAM) -------------

    @GetMapping("/dimensions")
    public ResponseEntity<List<VehicleDto>> getVehiclesByDimensions(
            @RequestParam double min_length,
            @RequestParam double max_length,
            @RequestParam double min_width,
            @RequestParam double max_width) {
        List<VehicleDto> vehicles = vehicleService.findVehiclesByDimensions(min_length, max_length, min_width, max_width);

        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }


}
