package com.example.concesionaria_autos.controller;

import com.example.concesionaria_autos.dto.VehicleRequestDto;
import com.example.concesionaria_autos.dto.VehicleResponseDto;
import com.example.concesionaria_autos.service.VehicleService.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

    @Autowired
    IVehicleService vehicleService;

    @PostMapping("/")
    public ResponseEntity<?> createVehicle(@RequestBody VehicleRequestDto vehicleDto){
        UUID idCreated = vehicleService.createVehicle(vehicleDto);
        return new ResponseEntity<>("Se creo con éxito el vehicle ID:  "+ idCreated, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleResponseDto>> getVehicles(){
        List<VehicleResponseDto> vehiclesDto = vehicleService.getVehicles();
        return new ResponseEntity<>(vehiclesDto, HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleResponseDto>> getVehicles(@RequestParam LocalDate since,
                                                                @RequestParam LocalDate to){
        List<VehicleResponseDto> vehiclesDto = vehicleService.getVehiclesByDate(since, to);
        return new ResponseEntity<>(vehiclesDto, HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleResponseDto>> getVehicles(@RequestParam Double since,
                                                                @RequestParam Double to){
        List<VehicleResponseDto> vehiclesDto = vehicleService.getVehiclesByPrice(since, to);
        return new ResponseEntity<>(vehiclesDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDto> getVehicle(@PathVariable UUID id){
        VehicleResponseDto vehiclesDto = vehicleService.getVehicle(id);
        return new ResponseEntity<>(vehiclesDto, HttpStatus.OK);
    }

}
