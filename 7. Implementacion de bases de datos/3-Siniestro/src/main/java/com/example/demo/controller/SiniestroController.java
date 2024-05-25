package com.example.demo.controller;

import com.example.demo.dto.SiniestroDTO;
import com.example.demo.dto.VehiculoDTO;
import com.example.demo.dto.VehiculoSiniestroDTO;
import com.example.demo.service.SiniestroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siniestros")
public class SiniestroController {

    @Autowired
    private SiniestroServiceImpl siniestroService;

    /*
    @GetMapping("/{id}")
    public ResponseEntity<Siniestro> getSiniestro(@PathVariable Long id) {
        Siniestro siniestro = siniestroService.getSiniestroById(id);
        return ResponseEntity.ok(siniestro);
    }

    @PostMapping
    public ResponseEntity<Void> createSiniestro(@RequestBody Siniestro siniestro) {
        siniestroService.saveSiniestro(siniestro);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
     */


    @GetMapping("/perdida")
    public ResponseEntity<List<VehiculoDTO>> listarPerdidaMayor10000() {
        List<VehiculoDTO> vehiculos = siniestroService.listarPerdidaMayor10000();
        return ResponseEntity.ok(vehiculos);
    }

    @GetMapping("/perdida_total")
    public ResponseEntity<List<VehiculoSiniestroDTO>> listarVehiculosConPerdidaMayorA10000YPerdidaTotal() {
        List<VehiculoSiniestroDTO> vehiculosSiniestroDTO = siniestroService.listarPerdidaMayor10000Total();
        return ResponseEntity.ok(vehiculosSiniestroDTO);
    }

}
