package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<?> addVehicles(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.createVehicle(vehicleDto),HttpStatus.CREATED);
    }


    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> searchVehiclesByColorAndYear(@PathVariable String color, @PathVariable int year)
    {
        return new ResponseEntity<>(vehicleService.searchVehiclesColorYear(color,year),HttpStatus.OK);
    }

    @PutMapping("vehicles/{id}/update_fuel")
    public ResponseEntity<?> updateFuel(@PathVariable Long id, @RequestBody VehicleDto vehicleDto)
    {
        return new ResponseEntity<>(vehicleService.updateFuel(vehicleDto,id),HttpStatus.OK);
    }

    @GetMapping("vehicles/weight")
    public ResponseEntity<?> searchVehiclesBywight(@RequestParam double weight_min, @RequestParam double weight_max)
    {
        return new ResponseEntity<>((weight_min + weight_max), HttpStatus.OK);
    }

}
