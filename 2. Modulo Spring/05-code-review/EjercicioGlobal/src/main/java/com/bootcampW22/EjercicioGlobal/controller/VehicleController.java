package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping()
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.createVehicle(vehicleDto), HttpStatus.CREATED);
    }

    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<?> getVehiclesByColorAndYear(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.getVehiclesByColorAndYear(color, year), HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}/between/{startYear}/{endYear}")
    public ResponseEntity<?> getVehiclesByBrandAndYearRange(@PathVariable String brand, @PathVariable int startYear, @PathVariable int endYear){
        return new ResponseEntity<>(vehicleService.getVehiclesByBrandAndYearRange(brand, startYear, endYear), HttpStatus.OK);
    }

    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageSpeedByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.getAverageSpeedByBrand(brand), HttpStatus.OK);
    }

    @PostMapping("/batch")
    public ResponseEntity<?> createMultipleVehicles(@RequestBody List<VehicleDto> vehicleDtos){
        return new ResponseEntity<>(vehicleService.createMultipleVehicles(vehicleDtos), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update_speed")
        public ResponseEntity<?> updateVehicleMaxSpeed(@PathVariable int id, @RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.updateVehicleMaxSpeed(id, vehicleDto), HttpStatus.OK);
    }

    @GetMapping("/fuel_type/{type}")
    public ResponseEntity<?> getVehiclesByFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.getVehiclesByFuelType(type), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable int id){
        return new ResponseEntity(vehicleService.deleteVehicle(id), HttpStatus.OK);
    }

    @GetMapping("/transmission/{type}")
    public ResponseEntity<?> getVehiclesByTransmissionType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.getVehiclesByTransmissionType(type), HttpStatus.OK);
    }

    @PutMapping("{id}/update_fuel")
    public ResponseEntity<?> updateVehicleFuelType(@PathVariable int id, @RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.updatedVehicleFuelType(id, vehicleDto), HttpStatus.OK);
    }

    @GetMapping("average_capacity/brand/{brand}")
    public ResponseEntity<?> getVehiclesAverageCapactityByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.getVehicleAverageCapacityByBrand(brand), HttpStatus.OK);
    }

    @GetMapping("/dimensions")
    public ResponseEntity<?> getVehiclesByDimensions(@RequestParam("min_length") double minLength,
                                                     @RequestParam("max_length") double maxLength,
                                                     @RequestParam("min_width") double minWidth,
                                                     @RequestParam("max_width") double maxWidth){
        return new ResponseEntity<>(vehicleService.getVehiclesByDimensions(minLength, maxLength, minWidth, maxWidth), HttpStatus.OK);
    }

    @GetMapping("/weight")
    public ResponseEntity<?> getVehiclesByWeightRange(@RequestParam("weight_min") double minWeight,
                                                      @RequestParam("weight_max") double maxWeight){
        return new ResponseEntity<>(vehicleService.getVehiclesByWeightRange(minWeight, maxWeight), HttpStatus.OK);
    }
}
