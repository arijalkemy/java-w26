package com.mercadolibre.Vehiculos_Sinietros.controller;

import com.mercadolibre.Vehiculos_Sinietros.model.dto.SiniestroRequestDto;
import com.mercadolibre.Vehiculos_Sinietros.model.dto.SiniestroResponseDto;
import com.mercadolibre.Vehiculos_Sinietros.model.dto.VehiculoRequestDto;
import com.mercadolibre.Vehiculos_Sinietros.model.dto.VehiculoResponseDto;
import com.mercadolibre.Vehiculos_Sinietros.service.ISiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siniestro")
public class SiniestroController {

    @Autowired
    ISiniestroService service;

    @PostMapping
    public ResponseEntity<SiniestroResponseDto> createSiniestro(@RequestBody SiniestroRequestDto siniestro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveSiniestro(siniestro));
    }

    @GetMapping
    public ResponseEntity<List<SiniestroResponseDto>> getAllSiniestro() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllSiniestro());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SiniestroResponseDto> getSiniestroById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getSiniestroById(id));
    }
}
