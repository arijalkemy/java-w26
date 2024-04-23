package com.demospring.personajesdestarwars.controller;

import com.demospring.personajesdestarwars.dto.PersonajeDTO;
import com.demospring.personajesdestarwars.model.Personaje;
import com.demospring.personajesdestarwars.service.IPersonajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajesController {
    @Autowired
    IPersonajes personajes;

    @GetMapping(path = "/{name}")
    public ResponseEntity<List<PersonajeDTO>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(personajes.getPersonaje(name));
    }
}
