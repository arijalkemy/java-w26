package org.example.vehiculos.controller;

import org.example.vehiculos.service.IVehiculoService;
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
    public ResponseEntity<?> listarTodasLasPatentes() {
        return ResponseEntity.ok(vehiculoService.listarTodasLasPatentes());
    }

    @GetMapping("/patentes/marcas")
    public ResponseEntity<?> listarPatentesYMarcaOrdenadoPorAnio() {
        return ResponseEntity.ok(vehiculoService.listarPatentesYMarcaOrdenadoPorAnio());
    }

    @GetMapping("/patentes/ruedas/mas_cuatro")
    public ResponseEntity<?> listarPatentesConMasDeCuatroRuedasFabricadosEsteAnio() {
        return ResponseEntity.ok(vehiculoService.listarPatentesConMasDeCuatroRuedasFabricadosEsteAnio());
    }

    @GetMapping("/matricula/marca/modelo")
    public ResponseEntity<?> listarMatriculaMarcaYModeloConSiniestroMayor() {
        return ResponseEntity.ok(vehiculoService.listarMatriculaMarcaYModeloConSiniestroMayor());
    }

    @GetMapping("/matricula/marca/modelo/perdida")
    public ResponseEntity<?> listarMatriculaMarcaModeloYPerdidaTotalConSiniestroMayor() {
        return ResponseEntity.ok(vehiculoService.listarMatriculaMarcaModeloYPerdidaTotalConSiniestroMayor());
    }

}
