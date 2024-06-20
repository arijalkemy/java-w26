package org.example.starwars.controller;

import org.example.starwars.dto.PersonajeResponse;
import org.example.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/personajes")
    public List<PersonajeResponse> buscarPersonajes(@RequestParam String palabra) throws IOException {
        return personajeService.buscarPersonajes(palabra);
    }
}

