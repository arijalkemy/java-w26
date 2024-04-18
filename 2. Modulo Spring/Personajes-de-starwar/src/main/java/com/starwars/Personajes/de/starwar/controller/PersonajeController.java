package com.starwars.Personajes.de.starwar.controller;

import com.starwars.Personajes.de.starwar.dto.ResponsePersonajeDto;
import com.starwars.Personajes.de.starwar.entity.Personaje;
import com.starwars.Personajes.de.starwar.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    PersonajeService personajeService;

    @Autowired
    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Personaje>> getAll(){
        List<Personaje> response = personajeService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/encontrar/{name}")
    public ResponseEntity<ResponsePersonajeDto> findByName(@PathVariable String name){
        ResponsePersonajeDto response = personajeService.findByName(name);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
