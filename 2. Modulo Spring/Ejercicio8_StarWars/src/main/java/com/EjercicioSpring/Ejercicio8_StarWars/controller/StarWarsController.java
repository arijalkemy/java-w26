package com.EjercicioSpring.Ejercicio8_StarWars.controller;

import com.EjercicioSpring.Ejercicio8_StarWars.dto.PersonajeDTO;
import com.EjercicioSpring.Ejercicio8_StarWars.service.IPersonajesService;
import com.EjercicioSpring.Ejercicio8_StarWars.service.PersonajesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {

    @GetMapping("/getPersonajes/{name}")
    public ResponseEntity<List<PersonajeDTO>> getPersonaje(@PathVariable String name) {
        IPersonajesService personajesService = new PersonajesService();
        List<PersonajeDTO> personajes = personajesService.getPersonajes(name);
        if (personajes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(personajes);
    }

}
