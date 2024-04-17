package org.example.starwars.controller;


import org.example.starwars.dto.PersonajeDTO;
import org.example.starwars.service.interfaces.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    IPersonajeService personajeService;

    @GetMapping("/personaje")
    ResponseEntity<List<PersonajeDTO>> getPersonaje(@RequestParam String personaje) {
        List<PersonajeDTO> personajes = personajeService.getPersonaje(personaje);
        if (personajes.isEmpty()) {
            return ResponseEntity.badRequest().body(personajeService.getPersonaje(personaje));
        }
        return ResponseEntity.ok().body(personajeService.getPersonaje(personaje));
    }
}
