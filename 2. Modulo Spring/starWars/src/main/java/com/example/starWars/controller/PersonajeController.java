package com.example.starWars.controller;

import com.example.starWars.dto.PersonajeDto;
import com.example.starWars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    IPersonajeService iPersonajeService;

    @GetMapping("/personajes/{nombre}")
    public ResponseEntity<PersonajeDto> getPersonajeByNombre(@PathVariable String name){
        return new ResponseEntity<>(iPersonajeService.findByName(name), HttpStatus.OK);
    }
}
