package org.example.covid19.controllers;

import org.example.covid19.services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonasController {
    @Autowired
    IPersonaService personaService;
    @GetMapping("/findRiskPerson")
    ResponseEntity<?> personasDeRiesgo(){
        return new ResponseEntity<>(personaService.buscarPersonasDeRiesgo(), HttpStatus.OK);
    }
}
