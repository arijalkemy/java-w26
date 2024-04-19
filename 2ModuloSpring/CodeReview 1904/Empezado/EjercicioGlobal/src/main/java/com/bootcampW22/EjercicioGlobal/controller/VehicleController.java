package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.RequestVehicleDTO;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

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
    public ResponseEntity<?> addVehicle(@Valid @RequestBody RequestVehicleDTO requestBody){
        return new ResponseEntity<>(vehicleService.addOneVehicle(requestBody), HttpStatus.OK);
    }
    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> getByFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.SearchByFuelTyple(type), HttpStatus.OK);
    }
    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> getVehiclesbyDimensions(@RequestParam String heigth, @RequestParam String width ){
        double[] heigths = Arrays.stream(heigth.split("-")).mapToDouble(h-> Double.valueOf(h)).toArray();
        double[] widths =Arrays.stream(width.split("-")).mapToDouble(h-> Double.valueOf(h)).toArray();
        return new ResponseEntity<>(vehicleService.SerachByDimension(heigths,widths), HttpStatus.OK);
    }

}
