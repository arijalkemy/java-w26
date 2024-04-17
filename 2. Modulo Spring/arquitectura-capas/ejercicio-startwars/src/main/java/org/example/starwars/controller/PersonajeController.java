package org.example.starwars.controller;

import org.example.starwars.dto.PersonajeDTO;
import org.example.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    @Autowired
    private IPersonajeService personajeService;


    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> buscarPorNombre(@RequestParam(required = false) String nombre) {

        if (nombre == null)
            return ResponseEntity.ok(personajeService.buscarTodos());
        else
            return ResponseEntity.ok(personajeService.buscarPorNombre(nombre));
    }
}
