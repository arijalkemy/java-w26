package com.example.starwars.controller;
import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.entity.Personaje;
import com.example.starwars.service.IPersonajeService;
import com.example.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Personajes")
public class PersonajeController {
    @Autowired
    IPersonajeService personajeService;

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> obtenerPersonajes(@PathVariable String nombre) {;
        return ResponseEntity.ok(personajeService.buscarPorNombre(nombre));
    }

}
