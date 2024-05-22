package org.example.vehiculohql.controller;

import org.example.vehiculohql.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    private final IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/patentes")
    ResponseEntity<?> retrieveAllPatentes(){
        return ResponseEntity.ok(vehiculoService.getAllPatentes());
    }

    @GetMapping("/modelos")
    ResponseEntity<?> retrieveAllModelos(){
        return ResponseEntity.ok(vehiculoService.getVehiculosOrdenados());
    }

    @GetMapping("/patentes/{year}")
    ResponseEntity<?> getPatentesByYear(@PathVariable Integer year){
        return ResponseEntity.ok(vehiculoService.getPatentesByYear(year));
    }

    @GetMapping("/all-siniestro/{perdida}")
    ResponseEntity<?> findAllSiniestro(@PathVariable Double perdida){
        return ResponseEntity.ok(vehiculoService.findAllSiniestro(perdida));
    }

    @GetMapping("/total-siniestro/{perdida}")
    ResponseEntity<?> getTotalSiniestro(@PathVariable Double perdida){
        return ResponseEntity.ok(vehiculoService.getTotalSiniestro(perdida));
    }
}
