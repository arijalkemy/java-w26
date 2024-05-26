package com.mercadolibre.concesionaria.controller;

import com.mercadolibre.concesionaria.dto.PatenteVehiculoDTO;
import com.mercadolibre.concesionaria.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping("/patentes")
    public ResponseEntity<?> listarPatentes(){
        return ResponseEntity.ok(vehiculoService.getAllPatentes());
    }

    @GetMapping("/patentesYMarcas")
    public ResponseEntity<?> listarPatentesYMarcas(){
        return ResponseEntity.ok(vehiculoService.getAllPatentesYMarcas());
    }

    @GetMapping("/patentesSegunRuedasYAnoDeFabricacion")
    public ResponseEntity<?> listarPatentesYAnoDeFabricacion(){
        return ResponseEntity.ok(vehiculoService.getPatentesSegunRuedasYAnoDeFabricacion());
    }

    @GetMapping("/siniestrosMayoresA10000")
    public ResponseEntity<?> listarVehiculosConSiniestrosMayoresA10000(){
        return ResponseEntity.ok(vehiculoService.getVehiculosConSiniestrosMayoresA10000());
    }

    @GetMapping("/siniestrosMayoresA10000/sumatoria")
    public ResponseEntity<?> listarVehiculosConSiniestrosMayoresA10000Sumatoria(){
        return ResponseEntity.ok(vehiculoService.getConjuntoVehiculosConSiniestrosMayoresA1000());
    }
}
