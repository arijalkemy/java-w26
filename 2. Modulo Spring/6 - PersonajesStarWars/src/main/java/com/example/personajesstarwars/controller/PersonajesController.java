package com.example.personajesstarwars.controller;

import com.example.personajesstarwars.dto.PersonajeDTO;
import com.example.personajesstarwars.services.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajesController {
    @Autowired
    IPersonajeService personajeService;

    @GetMapping("{nombre}")
    public ResponseEntity<List<PersonajeDTO>> obtenerPersonajes(@PathVariable String nombre){
        return ResponseEntity.ok(personajeService.buscarPorNombre(nombre));
    }
    @GetMapping
    public ResponseEntity<String> metodoPrueba(){
        return new ResponseEntity<>("Hola!", HttpStatus.OK);
    }
}
