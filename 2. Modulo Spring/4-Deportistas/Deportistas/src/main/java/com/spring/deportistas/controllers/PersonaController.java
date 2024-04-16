package com.spring.deportistas.controllers;

import com.spring.deportistas.DTOs.DeportistaDTO;
import com.spring.deportistas.services.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    IDeporteService deporteService;

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> getAllSportsmans(){
        return new ResponseEntity<>(deporteService.buscarDeportistas(), HttpStatus.OK);
    }
}
