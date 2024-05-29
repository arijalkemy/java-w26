package com.prendas.controllers;

import com.prendas.DTOs.request.PrendaRequestDTO;
import com.prendas.services.IPrendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
@RequiredArgsConstructor
public class PrendaController {

    private final IPrendaService prendaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PrendaRequestDTO prendaDTO) {
        return new ResponseEntity<>(
                prendaService.crear(prendaDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(required = false, name = "name") String nombre) {
        return new ResponseEntity<>(
                nombre == null ? prendaService.getAll() : prendaService.findByName(nombre),
                HttpStatus.OK
        );
    }

    @GetMapping("{code}")
    public ResponseEntity<?> findByCode(@PathVariable String code) {
        return new ResponseEntity<>(
                prendaService.findByCode(code),
                HttpStatus.OK
        );
    }

    @PutMapping("{code}")
    public ResponseEntity<?> update(@PathVariable String code, @RequestBody PrendaRequestDTO prendaDTO) {
        return new ResponseEntity<>(
                prendaService.update(
                        code,
                        prendaDTO
                ),
                HttpStatus.OK
        );
    }


    @DeleteMapping("{code}")
    public ResponseEntity<?> delete(@PathVariable String code) {
        prendaService.delete(code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("size/{size}")
    public ResponseEntity<?> findBySize(@PathVariable String size) {
        return new ResponseEntity<>(
                prendaService.findBySize(size),
                HttpStatus.OK
        );
    }
}
