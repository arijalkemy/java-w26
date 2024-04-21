package com.example.ejercicio_arquitectura_multicapa_p1_vivo.controller;

import com.example.ejercicio_arquitectura_multicapa_p1_vivo.dto.PersonajeDto;
import com.example.ejercicio_arquitectura_multicapa_p1_vivo.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {
    @Autowired
    private IPersonajeService personajeService;

    @GetMapping("")
    public ResponseEntity<List<PersonajeDto>> obtenerPersonajes(
            @RequestParam String name
    ) {
        return new ResponseEntity<>(
                personajeService.buscarPersonajes(name),
                HttpStatus.OK
        );
    }
}
