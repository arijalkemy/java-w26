package com.ejercicio.covid19.controllers;

import com.ejercicio.covid19.DTOs.RiskPersonResponseDTO;
import com.ejercicio.covid19.services.interfaces.IPersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonsController {
    @Autowired
    IPersonsService personsService;

    @GetMapping("/findRiskPerson")
    public List<RiskPersonResponseDTO> getRiskPersons() {
        return personsService.getRiskPersons();
    }
}
