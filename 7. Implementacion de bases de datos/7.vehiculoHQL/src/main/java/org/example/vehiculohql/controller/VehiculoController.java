package org.example.vehiculohql.controller;

import org.example.vehiculohql.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired
    IVehiculoService vehiculoService;

    @GetMapping("/patentes")
    ResponseEntity<?> retrieveAllPatentes(){
        return ResponseEntity.ok(vehiculoService.getAllPatentes());
    }

    @GetMapping("/modelos")
    ResponseEntity<?> retrieveAllModelos(){
        return ResponseEntity.ok(vehiculoService.getVehiculosOrdenados());
    }
}
