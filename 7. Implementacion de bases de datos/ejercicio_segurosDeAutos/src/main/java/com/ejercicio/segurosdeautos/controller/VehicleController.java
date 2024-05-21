package com.ejercicio.segurosdeautos.controller;

import com.ejercicio.segurosdeautos.service.interfaces.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @GetMapping("/patents")
    public ResponseEntity<List<String>> getAllPatents() {
        return ResponseEntity.ok(
                vehicleService.getAllPatents()
        );
    }
}
