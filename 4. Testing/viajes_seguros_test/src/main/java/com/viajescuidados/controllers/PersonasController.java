package com.viajescuidados.controllers;

import com.viajescuidados.dtos.PersonaDTO;
import com.viajescuidados.dtos.responses.PersonaResponseDTO;
import com.viajescuidados.services.interfaces.IPersonasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
public class PersonasController {
    @Autowired
    private IPersonasService personasService;

    @PostMapping
    public ResponseEntity<PersonaResponseDTO> agregarPersona(@RequestBody @Valid PersonaDTO personaDTO) {
        return ResponseEntity.ok(personasService.crearPersona(personaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaResponseDTO> buscarPersona(@PathVariable Integer id) {
        return ResponseEntity.ok(personasService.buscarPersona(id));
    }
}
