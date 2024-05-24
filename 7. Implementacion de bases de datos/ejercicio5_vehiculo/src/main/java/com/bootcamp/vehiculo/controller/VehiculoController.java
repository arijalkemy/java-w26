package com.bootcamp.vehiculo.controller;

import com.bootcamp.vehiculo.dto.ResponseDTO;
import com.bootcamp.vehiculo.dto.VehiculoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.vehiculo.service.IVehiculoService;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    private final IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<String>> getAllPatentes() {
        return ResponseEntity.ok().body(vehiculoService.getAllPatentes());
    }

    @GetMapping("/patente-marca")
    public ResponseEntity<List<VehiculoDTO>> getPatentesYMarcaPorAnio() {
        return ResponseEntity.ok().body(vehiculoService.getPatentesYMarcaOrdenadoPorAnio());
    }

    @GetMapping("/patentes-cuatro-ruedas")
    public ResponseEntity<List<String>> getAllPatentesByVehiculosCuatroRuedas() {
        return ResponseEntity.ok().body(vehiculoService.getPatentesByCuatroRuedasYAnioCorriente());
    }

    @GetMapping("/perdida-mayor-10000")
    public ResponseEntity<List<VehiculoDTO>> getMatriculaMarcaModeloPerdidaMayorA() {
        return ResponseEntity.ok().body(vehiculoService.getMatriculaMarcaModeloPerdidaMayorA(10000));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> postTestCase(@RequestBody VehiculoDTO vehiculoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculoService.postVehiculo(vehiculoDTO));
    }

}