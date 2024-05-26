package org.example.hqlvivo.Controller;


import lombok.RequiredArgsConstructor;
import org.example.hqlvivo.DTOs.Request.CreateSiniestroRequestDto;
import org.example.hqlvivo.DTOs.Response.PatenteMarcaModeloResponseDto;
import org.example.hqlvivo.DTOs.Response.PatenteMarcaModeloTotalPerdidaResponseDto;
import org.example.hqlvivo.DTOs.Response.SiniestroResponseDto;
import org.example.hqlvivo.Service.ISiniestroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/siniestro")
@RequiredArgsConstructor
public class SiniestroController {
    private final ISiniestroService service;

    @PostMapping("/create")
    public ResponseEntity<SiniestroResponseDto> create(@RequestBody CreateSiniestroRequestDto request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/list")
    public ResponseEntity<List<SiniestroResponseDto>> getAll() {
        return ResponseEntity.ok(service.searchAll());
    }

    @GetMapping("/list/siniestro-perdida-mayor-diezmil")
    public ResponseEntity<List<PatenteMarcaModeloResponseDto>> getAllDatosSiniestroWithPerdidaMayorDiezMil() {
        return ResponseEntity.ok(service.searchAllDatosSiniestroWithPerdidaMayorDiezMil());
    }

    @GetMapping("/list/siniestro-perdida-mayor-diezmil-y-total-perdida")
    public ResponseEntity<List<PatenteMarcaModeloTotalPerdidaResponseDto>> getAllDatosSiniestroWithPerdidaMayorDiezMilAndTotalPerdida() {
        return ResponseEntity.ok(service.searchAllDatosSiniestroWithPerdidaMayorDiezMilAndTotalPerdida());
    }
}
