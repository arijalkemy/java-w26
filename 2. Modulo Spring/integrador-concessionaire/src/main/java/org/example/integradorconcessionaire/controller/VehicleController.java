package org.example.integradorconcessionaire.controller;


import org.example.integradorconcessionaire.dto.VehicleRequestDTO;
import org.example.integradorconcessionaire.dto.VehicleResponseDTO;
import org.example.integradorconcessionaire.dto.VehicleResponseDetailDTO;
import org.example.integradorconcessionaire.service.impl.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/")
public class VehicleController {

    private final VehicleServiceImpl vehicleServiceImpl;

    @Autowired
    public VehicleController(VehicleServiceImpl vehicleServiceImpl){
        this.vehicleServiceImpl = vehicleServiceImpl;
    }

    @PostMapping("vehicles/")
    @ResponseBody

    public ResponseEntity<String> addVehicle(@RequestBody VehicleRequestDTO requestDTO){
        return new ResponseEntity<>(vehicleServiceImpl.addVehicle(requestDTO), HttpStatus.OK);
    }

    @GetMapping("vehicles/")
    @ResponseBody
    public ResponseEntity<List<VehicleResponseDTO>> getUsedVehicles(){
        return new ResponseEntity<>(vehicleServiceImpl.getUsed(), HttpStatus.OK);
    }

    @GetMapping("vehicles/dates")
    @ResponseBody
    public ResponseEntity<List<VehicleResponseDetailDTO>> filterVehicleByDate(
            @RequestParam("since") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ){
        return new ResponseEntity<>(vehicleServiceImpl.getByDateRange(start, end), HttpStatus.OK);
    }

    @GetMapping("vehicles/price")
    @ResponseBody
    public ResponseEntity<List<VehicleResponseDetailDTO>> filterVehicleByPrice(
            @RequestParam("since") double min, @RequestParam("to") double max
    ){
        return new ResponseEntity<>(vehicleServiceImpl.getByPriceRange(min, max), HttpStatus.OK);
    }

    @GetMapping("vehicles/{vehicleId}")
    @ResponseBody
    public ResponseEntity<VehicleResponseDetailDTO> findVehicleById(@PathVariable UUID vehicleId){
        return new ResponseEntity<>(vehicleServiceImpl.retreatVehicleInfo(vehicleId),HttpStatus.OK);
    }

}
