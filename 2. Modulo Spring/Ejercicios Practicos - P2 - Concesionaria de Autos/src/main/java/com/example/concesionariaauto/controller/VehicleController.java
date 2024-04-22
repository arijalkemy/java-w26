package com.example.concesionariaauto.controller;

import com.example.concesionariaauto.dto.VehicleAllResponseDTO;
import com.example.concesionariaauto.dto.VehicleRequestDTO;
import com.example.concesionariaauto.dto.VehicleResponseDTO;
import com.example.concesionariaauto.service.IVehicleService;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @PostMapping("")
    public ResponseEntity<VehicleResponseDTO> createVehicle(@RequestBody VehicleRequestDTO vehicle){
        return new ResponseEntity<>(vehicleService.addVehicle(vehicle), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<VehicleResponseDTO>> getVehicles(){
        return new ResponseEntity<>(vehicleService.listVehicle(), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleResponseDTO>> getDates(
            @RequestParam LocalDate since,
            @RequestParam LocalDate to)
    {
        return new ResponseEntity<>(vehicleService.listVehicleFromManufacturingDate(since, to), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleResponseDTO>> getPrices(
            @RequestParam int since,
            @RequestParam int to)
    {
        return new ResponseEntity<>(vehicleService.listVehicleFromPrice(since, to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleAllResponseDTO> getVehicleById(@PathVariable UUID id){
        return new ResponseEntity<>(vehicleService.getVehicleById(id), HttpStatus.OK);
    }
}
