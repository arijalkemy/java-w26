package org.bootcamp.covid.controller;

import org.bootcamp.covid.dto.PersonDTO;
import org.bootcamp.covid.dto.SymptomDTO;
import org.bootcamp.covid.service.ICovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {
    @Autowired
    ICovidService covidService;

    @GetMapping("findSymptoms")
    public ResponseEntity<?> findSymptoms() {
        List<SymptomDTO> symptoms = covidService.findSymptoms();
        return ResponseEntity.ok(symptoms);
    }

    @GetMapping("findSymptom/{name}")
    public ResponseEntity<?> findSymptomByName(@PathVariable String name) {
        SymptomDTO symptom = covidService.findSymptomByName(name);
        return ResponseEntity.ok(symptom);
    }

    @GetMapping("findRiskPerson")
    public ResponseEntity<?> findRiskPerson() {
        List<PersonDTO> persons = covidService.findRiskPerson();
        return ResponseEntity.ok(persons);
    }
}
