package org.ejercicio.starwars.controller;

import org.ejercicio.starwars.dto.PersonajeDTO;
import org.ejercicio.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping
public class PersonajeController {

    @Autowired
   IPersonajeService personajeService;
    @GetMapping("/personajes/{name}")
    public List<PersonajeDTO> mostrarPersonajes(@PathVariable String name) throws IOException {
       return personajeService.mostrarPersonajes(name);

    }


}
