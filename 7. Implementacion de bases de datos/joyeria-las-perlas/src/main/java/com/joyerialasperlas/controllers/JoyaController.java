package com.joyerialasperlas.controllers;

import com.joyerialasperlas.DTOs.JoyaDTO;
import com.joyerialasperlas.services.interfaces.IJoyaService;
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
        return joyaService.create(joyaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return joyaService.findById(id);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return joyaService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody JoyaDTO joyaDTO
    )
    {
        return joyaService.update(id, joyaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return joyaService.delete(id);
    }
}
