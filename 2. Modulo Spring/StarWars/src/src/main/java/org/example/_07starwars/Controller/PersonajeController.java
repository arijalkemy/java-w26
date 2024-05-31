package org.example._07starwars.Controller;

import org.example._07starwars.DTO.PersonajeDTO;
import org.example._07starwars.Repository.IRepositorio;
import org.example._07starwars.Service.IPersonajeService;
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
    IPersonajeService personajeService;

    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> obtenerTodos(@RequestParam String nombre) {
        return ResponseEntity.ok().body("");
        //return ResponseEntity.ok().body(personajeService.buscarPorNombre(nombre));
    }
}

@RestController
@RequestMapping("/personajes")

public class PersonajeController {

    @Autowired
    IPersonajeService personajeService;

    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> obtenerTodos(@RequestParam String nombre) {
        return ResponseEntity.ok().body(personajeService.buscarPorNombre(nombre));
    }
}
