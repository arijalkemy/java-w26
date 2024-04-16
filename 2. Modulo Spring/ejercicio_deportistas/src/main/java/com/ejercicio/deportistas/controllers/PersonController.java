package com.ejercicio.deportistas.controllers;

import com.ejercicio.deportistas.DTOs.SportPersonResponseDTO;
import com.ejercicio.deportistas.services.interfaces.IPersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    IPersonsService personsService;

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportPersonResponseDTO>> getSportsPersons() {
        return ResponseEntity
                .status(200)
                .body(personsService.getSportsPersons());
    }
}
