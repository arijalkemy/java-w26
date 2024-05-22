package com.ejercicio.segurosdeautos.controller;

import com.ejercicio.segurosdeautos.DTO.VehicleDTO;
import com.ejercicio.segurosdeautos.service.interfaces.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/vehiculo")
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @GetMapping("/perdidas-suma")
    public ResponseEntity<List<VehicleDTO>> findVehiclesByEchonomicLostGreatherThan() {
        return ResponseEntity.ok(vehicleService.findVehiclesByEchonomicLostGreatherThan());
    }

    @GetMapping("/perdidas")
    public ResponseEntity<List<VehicleDTO>> findVehiclesByEchonomicLost() {
        return ResponseEntity.ok(vehicleService.findVehiclesByEchonomicLost());
    }

    @GetMapping("/patente")
    public ResponseEntity<List<VehicleDTO>> findAllPatents() {
        return ResponseEntity.ok(vehicleService.findAllPatents());
    }

    @GetMapping("/fabricacion")
    public ResponseEntity<List<VehicleDTO>> findAllVehiclesOrderByFabricationYear() {
        return ResponseEntity.ok(vehicleService.findAllVehiclesOrderByFabricationYear());
    }

    @GetMapping("/ruedas")
    public ResponseEntity<List<VehicleDTO>> findPatentsByWheelsAndYear() {
        return ResponseEntity.ok(vehicleService.findPatentsByWheelsAndYear());
    }
}