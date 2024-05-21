package com.joyerialasperlas.controllers;

import com.joyerialasperlas.DTOs.JoyaDTO;
import com.joyerialasperlas.services.interfaces.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody JoyaDTO joyaDTO) {
        return new ResponseEntity<>(
                joyaService.create(joyaDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(
                joyaService.findById(id),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(
                joyaService.findAll(),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody JoyaDTO joyaDTO
    )
    {
        return new ResponseEntity<>(
                joyaService.update(id, joyaDTO),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        joyaService.delete(id);
        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
        );
    }
}
