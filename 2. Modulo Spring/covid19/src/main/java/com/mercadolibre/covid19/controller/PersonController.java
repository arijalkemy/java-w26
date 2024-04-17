package com.mercadolibre.covid19.controller;

import com.mercadolibre.covid19.model.dto.RiskPerson;
import com.mercadolibre.covid19.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "person")
public class PersonController {
    @Autowired
    private IPersonService personService;

    @GetMapping("risk-person")
    public ResponseEntity<List<RiskPerson>> findAllRiskPersons() {
        return ResponseEntity.ok(personService.findRiskPerson());
    }
}
