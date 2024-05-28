package com.example.siniestros.controller;

import com.example.siniestros.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/vehiculo")
public class VehiculoController {
    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping(path = "/patente")
    public ResponseEntity<?> getAllPatentes() {
        return ResponseEntity.ok(vehiculoService.getAllPatentes());
    }

    @GetMapping(path = "/marca-patente")
    public ResponseEntity<?> getAllPatentesMarcasOrderByAnio() {
        return ResponseEntity.ok(vehiculoService.getAllPatenteMarcaOrderByAnio());
    }

    @GetMapping(path = "/pantente-ruedas-anio")
    public ResponseEntity<?> getAllPatenteFourWheelsAndCurrentYear() {
        return ResponseEntity.ok(vehiculoService.getAllPatenteFourWheelsAndCurrentYear());
    }

    @GetMapping(path = "/siniestro")
    public ResponseEntity<?> getAllVehiclesWithSinistes() {
        return ResponseEntity.ok(vehiculoService.getAllVehiclesWithSinistes());
    }
}
