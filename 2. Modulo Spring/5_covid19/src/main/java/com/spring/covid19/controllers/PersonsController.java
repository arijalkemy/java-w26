package com.spring.covid19.controllers;

import com.spring.covid19.models.dto.RiskPersonDTO;
import com.spring.covid19.services.IPersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonsController {

    private final IPersonsService personsService;

    @Autowired
    public PersonsController(IPersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/findRiskPerson")
    ResponseEntity<List<RiskPersonDTO>> findRiskPerson(@RequestParam(required = false) Integer maxAge) {
        if(maxAge == null) {
            maxAge = 1000;
        }
        return ResponseEntity.ok(
                this.personsService.getAllRiskPersons(maxAge)
        );
    }
}
