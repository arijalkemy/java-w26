package com.prendaselastic.controllers;

import com.prendaselastic.DTOs.request.PrendaRequestDTO;
import com.prendaselastic.services.IPrendaService;
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
    public ResponseEntity<?> getAll(
            @RequestParam(required = false, name = "name") String name
    ) {
        return new ResponseEntity<>(
                name == null ? prendaService.getAll() : prendaService.findByName(name),
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
