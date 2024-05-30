package com.example.showroom.controller;

import com.example.showroom.dto.PrendaDto;
import com.example.showroom.dto.PrendaResponseDto;
import com.example.showroom.service.IPrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {

    @Autowired
    IPrendaService service;

    @PostMapping("")
    public ResponseEntity<PrendaResponseDto> createPrenda(@RequestBody PrendaDto prenda){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.savePrenda(prenda));
    }

    @GetMapping("")
    public ResponseEntity<List<PrendaResponseDto>> getAllPrendas(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllPrendas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrendaResponseDto> getPrendaById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getPrendaById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrendaResponseDto> updatePrenda(@PathVariable Long id, @RequestBody PrendaDto prenda){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.updatePrenda(id,prenda));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrenda(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deletePrenda(id));
    }

    @GetMapping("/talla/{talla}")
    public ResponseEntity<List<PrendaResponseDto>> getAllPrendasBySize(@PathVariable String talla){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllPrendasByTalla(talla));
    }

    @GetMapping("/type")
    public ResponseEntity<List<PrendaResponseDto>> getAllPrendasByType(@RequestParam String tipo){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllPrendasByTipo(tipo));
    }

}
