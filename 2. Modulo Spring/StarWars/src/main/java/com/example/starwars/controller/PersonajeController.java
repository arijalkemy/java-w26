package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.service.impl.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    private final PersonajeServiceImpl personajeService;

    public PersonajeController(PersonajeServiceImpl _personajeService) {
        this.personajeService = _personajeService;
    }

    @GetMapping("/personaje/{nombre}")
    public List<PersonajeDTO> personajesPorNombre(@PathVariable String nombre){
        return personajeService.personajesPorNombre(nombre);
    }
}
