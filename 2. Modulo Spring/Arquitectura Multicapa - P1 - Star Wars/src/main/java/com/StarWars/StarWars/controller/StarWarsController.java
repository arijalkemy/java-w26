package com.StarWars.StarWars.controller;

import com.StarWars.StarWars.dto.PersonajeDTO;
import com.StarWars.StarWars.services.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    @Autowired
    private IStarWarsService starWarsService;

    @GetMapping("")
    ResponseEntity<List<PersonajeDTO>> getAllStarWars() {
        List<PersonajeDTO> listaPersonaje = starWarsService.obtenerPersonajes();
        return ResponseEntity.ok(listaPersonaje);
    }

    @GetMapping("/{nombre}")
    ResponseEntity<List<PersonajeDTO>> buscarPersonajes(@PathVariable String nombre) {
        List<PersonajeDTO> listaPersonaje = starWarsService.buscarPersonajes(nombre);
        return ResponseEntity.ok(listaPersonaje);
    }
}
