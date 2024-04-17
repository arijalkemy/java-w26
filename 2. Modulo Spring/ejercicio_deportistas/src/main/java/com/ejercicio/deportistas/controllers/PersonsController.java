package com.ejercicio.deportistas.controllers;

import com.ejercicio.deportistas.DTOs.SportsPersonsResponseDTO;
import com.ejercicio.deportistas.services.interfaces.IPersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonsController {
    @Autowired
    IPersonsService personsService;

    @GetMapping("/findSportsPersons")
    public List<SportsPersonsResponseDTO> getSportsPersons() {
        return personsService.getSportsPersons();
    }
}
