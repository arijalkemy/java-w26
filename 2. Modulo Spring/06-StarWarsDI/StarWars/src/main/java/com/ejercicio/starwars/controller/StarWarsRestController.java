package com.ejercicio.starwars.controller;

import com.ejercicio.starwars.dto.PersonajeDTO;
import com.ejercicio.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personaje")
public class StarWarsRestController {

    @Autowired
    IPersonajeService personajeService;

    @GetMapping("/{nombrePersonaje}")
    public ResponseEntity<List<PersonajeDTO>> getPersonaje(@PathVariable String nombrePersonaje){
        return ResponseEntity.ok().body(personajeService.getPersonajePorNombre(nombrePersonaje));
    }
}
