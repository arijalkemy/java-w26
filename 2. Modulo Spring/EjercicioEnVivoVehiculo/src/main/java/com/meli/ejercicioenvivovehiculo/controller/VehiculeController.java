package com.meli.ejercicioenvivovehiculo.controller;

import com.meli.ejercicioenvivovehiculo.dto.VehiculeDTO;
import com.meli.ejercicioenvivovehiculo.service.IVehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/api")
public class VehiculeController {

    @Autowired
    IVehiculeService iVehiculeService;


    @GetMapping("/vehicles")
    public ResponseEntity<?> returnVehicles(){
        return ResponseEntity.ok(iVehiculeService.getVehicules());
    }

    @GetMapping("/vehicles/dates/")
    public ResponseEntity<?> returnByDate(@RequestParam(value = "since") LocalDate since, @RequestParam(value = "to") LocalDate to){
        return ResponseEntity.ok(iVehiculeService.getVehiculeByManufactureDate(since,to));
    }

    @GetMapping("/vehicles/price")
    public ResponseEntity<?> returnByPrice(@RequestParam(value = "since") int since, @RequestParam(value = "to") int to){
        return ResponseEntity.ok(iVehiculeService.getVehiculeByPrice(since,to));
    }


    @GetMapping("/vehicles/")
    public ResponseEntity<?> returnById(@RequestParam(value = "id") int id){
        return ResponseEntity.ok(iVehiculeService.getVehicule(id));
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> returnById(@RequestBody VehiculeDTO vehicule){
        return ResponseEntity.ok(iVehiculeService.createVehicule(vehicule));
    }











}
