package com.meli.concesionaria.controller;

import com.meli.concesionaria.dto.RequestPostVehicleDto;
import com.meli.concesionaria.dto.ResponseVehicleDto;
import com.meli.concesionaria.entity.Vehicle;
import com.meli.concesionaria.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles/")
public class VehicleController {

    VehicleService vehicleService;
    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    @GetMapping()
    public ResponseEntity<List<ResponseVehicleDto>> findAll(){
        List<ResponseVehicleDto> response = vehicleService.getAllVehicles();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<ResponseVehicleDto>> getAllByDate(@RequestParam String since, @RequestParam String to){
        List<ResponseVehicleDto> response = vehicleService.getVehiclesByDate(since,to);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/prices")
    public ResponseEntity<List<ResponseVehicleDto>> getAllByPrice(@RequestParam Integer since, @RequestParam Integer to){
        List<ResponseVehicleDto> response = vehicleService.getVehiclesByPrice(since,to);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> geyById(@PathVariable Integer id) {
        Vehicle response = vehicleService.getVehicleById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping()
    public ResponseEntity<Vehicle> createVehicle(@RequestBody RequestPostVehicleDto requestPostVehicleDto) {
        Vehicle response = vehicleService.addVehicle(requestPostVehicleDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
