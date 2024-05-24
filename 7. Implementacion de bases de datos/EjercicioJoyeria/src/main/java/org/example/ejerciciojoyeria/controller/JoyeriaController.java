package org.example.ejerciciojoyeria.controller;

import org.example.ejerciciojoyeria.dto.JoyaRequestDTO;
import org.example.ejerciciojoyeria.dto.JoyaResponseDTO;
import org.example.ejerciciojoyeria.service.IJoyeriaService;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyeriaController {
    @Autowired
    private IJoyeriaService service;

    @PostMapping("/new")
    public ResponseEntity<String> saveJewerly(@RequestBody JoyaRequestDTO joya) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveJoya(joya));
    }
    @GetMapping
    public ResponseEntity<List<JoyaResponseDTO>> getAllJewerly() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllJoyas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<JoyaResponseDTO> getJewerlyById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getJoyaById(id));
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<String> deleteJewerly(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteJoya(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateJewerly(@PathVariable Long id, @RequestBody JoyaRequestDTO joya) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateJoya(id, joya));
    }
}
