package com.personajes.starwars.controller;

import com.personajes.starwars.dto.PersonajeDTO;
import com.personajes.starwars.model.PersonajeStarWars;
import com.personajes.starwars.service.StarWarsPersonajes;
import com.personajes.starwars.service.impl.StarWarsPersonajesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starWars")
public class StarWarsController {

    @Autowired
    StarWarsPersonajes starWarsPersonajes;

    @GetMapping("/personaje/{name}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajeByName(@PathVariable String name) {

        List<PersonajeDTO> personajesDTOList =  starWarsPersonajes.getPersonajeByName(name);

        return new ResponseEntity<>(personajesDTOList, HttpStatus.OK);
    }
}
