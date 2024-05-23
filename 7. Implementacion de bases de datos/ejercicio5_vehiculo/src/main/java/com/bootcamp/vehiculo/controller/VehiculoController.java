package com.bootcamp.vehiculo.controller;

import com.bootcamp.vehiculo.dto.ResponseDTO;
import com.bootcamp.vehiculo.dto.SiniestroDTO;
import com.bootcamp.vehiculo.dto.VehiculoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // 3.- Listar la patente de todos los vehículos que tengan más de cuatro ruedas
    // y hayan sido fabricados en el corriente año.
    @GetMapping("/patentes-cuatro-ruedas")
    public ResponseEntity<List<String>> getAllPatentesByVehiculosCuatroRuedas() {
        return ResponseEntity.ok().body(vehiculoService.getPatentesByCuatroRuedasYAnioCorriente());
    }

    // 4.- Listar la matrícula, marca y modelo de todos los vehículos que hayan
    // tenido un siniestro con pérdida mayor de 10000 pesos.
    @GetMapping("/perdida-mayor-10000")
    public ResponseEntity<?> getMatriculaMarcaModeloPerdidaMayorA() {
        return ResponseEntity.ok().body(vehiculoService.getMatriculaMarcaModeloPerdidaMayorA(10000));
    }

    @PostMapping("/new-vehiculo")
    public ResponseEntity<ResponseDTO> postTestCase(@RequestBody VehiculoDTO vehiculoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculoService.postVehiculo(vehiculoDTO));
    }

    @PostMapping("/new-siniestro/{vehiculoId}")
    public ResponseEntity<ResponseDTO> postTestCase(@PathVariable Long vehiculoId,
                                                    @RequestBody SiniestroDTO siniestroDTO) {
        ResponseDTO messageRes = vehiculoService.postSiniestro(vehiculoId, siniestroDTO);
        return new ResponseEntity<>(messageRes, HttpStatusCode.valueOf(201));
    }
}