package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleRequestDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleResponseDto;
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


    //Punto 1
    @PostMapping("/save")
    public ResponseEntity<?> createVehicle (@RequestBody VehicleRequestDto vehicleRequestDto){
        vehicleService.createVehicle(vehicleRequestDto);
        return new ResponseEntity<>("Vehículo creado exitosamente", HttpStatus.OK);
    }

    @GetMapping("/getByColor")
    public ResponseEntity<VehicleResponseDto> getBy(@RequestParam String color, Integer year){
       VehicleResponseDto vehicleResponseDto = vehicleService.getVehicleBy(color, year);
        return new ResponseEntity<>(vehicleResponseDto, HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> getByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.getByBrand(brand), HttpStatus.OK);
    }


    @DeleteMapping("deleteVehicle/")
    public ResponseEntity<?> deleteVehicle(@RequestParam Long id){
        vehicleService.deleteVehicle(id);
       return  new ResponseEntity<>(HttpStatus.OK);

    }
}
