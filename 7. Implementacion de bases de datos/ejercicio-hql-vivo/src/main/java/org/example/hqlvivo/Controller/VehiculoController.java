package org.example.hqlvivo.Controller;

import lombok.RequiredArgsConstructor;
import org.example.hqlvivo.DTOs.Request.CreateVehiculoRequestDto;
import org.example.hqlvivo.DTOs.Response.PatenteMarcaModeloResponseDto;
import org.example.hqlvivo.DTOs.Response.VehiculoResponseDto;
import org.example.hqlvivo.Service.IVehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
@RequiredArgsConstructor
public class VehiculoController {
    private final IVehiculoService service;

    @PostMapping("/create")
    public ResponseEntity<VehiculoResponseDto> create(@RequestBody CreateVehiculoRequestDto request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/list")
    public ResponseEntity<List<VehiculoResponseDto>> searchAll() {
        return ResponseEntity.ok(service.searchAll());
    }

    @GetMapping("/list/plates")
    public ResponseEntity<List<String>> getAllPlates() {
        return ResponseEntity.ok(service.searchAllPlates());
    }

    @GetMapping("/list/patente-y-marca")
    public ResponseEntity<List<PatenteMarcaModeloResponseDto>> getAllPatenteMarca() {
        return ResponseEntity.ok(service.searchAllPatenteMarcaOrderAsc());
    }

    @GetMapping("/list/patente-y-marca/{anio}")
    public ResponseEntity<List<String>> getAllPatentesByAnioAndMoreThanFourRuedas(@PathVariable Integer anio) {
        return ResponseEntity.ok(service.searchAllPatentesByAnioAndMoreThanFourRuedas(anio));
    }
}
