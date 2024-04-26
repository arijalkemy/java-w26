package com.example.starWars.controller;

import com.example.starWars.dto.PersonajeDTO;
import com.example.starWars.service.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class PersonajeController {

    @Autowired
    PersonajeServiceImpl personajeService;

    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> personajesPorNombre(@RequestParam String nombre){
        return new ResponseEntity<>(personajeService.personajesPorNombre(nombre), HttpStatus.OK);
        //return ResponseEntity.status(200).body(personajeService.personajesPorNombre(nombre));
        //return ResponseEntity.ok(personajeService.personajesPorNombre(nombre));
    }
}
