package com.spring.covid19.controllers;

import com.spring.covid19.dtos.RiskPersonDTO;
import com.spring.covid19.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("findRiskPerson")
public class PersonController {
    @Autowired
    IPersonService personService;

    @GetMapping
    public ResponseEntity<List<RiskPersonDTO>> findRiskPersons() {
        return ResponseEntity.ok(personService.findRiskPersons());
    }
}
