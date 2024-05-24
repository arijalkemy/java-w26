package com.bootcamp.vehiculo.controller;

import com.bootcamp.vehiculo.dto.SiniestroDTO;
import com.bootcamp.vehiculo.service.ISiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/siniestro")
public class SiniestroController {

    private final ISiniestroService siniestroService;

    @Autowired
    public SiniestroController(ISiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @PostMapping("/vehiculo/{vehiculoId}")
    public ResponseEntity<SiniestroDTO> create(@PathVariable Long vehiculoId,
                                               @RequestBody SiniestroDTO siniestroDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(siniestroService.save(vehiculoId, siniestroDTO));
    }

}
