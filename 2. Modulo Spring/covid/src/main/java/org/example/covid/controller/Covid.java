package org.example.covid.controller;


import org.example.covid.dto.PersonaEnRiesgoDTO;
import org.example.covid.entity.Sintoma;
import org.example.covid.services.interfaces.ICovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Covid {
    @Autowired
    ICovidService covidService;

    @GetMapping("/findSymptom")
    ResponseEntity<List<Sintoma>> findSymptom() {
        return ResponseEntity.ok().body(covidService.findSymptom());
    }

    @GetMapping("findSymptom/{name}")
    public ResponseEntity<List<Sintoma>> findSymptom(@PathVariable String name) {
        List<Sintoma> response = covidService.findSymptomByName(name);
        if (response.isEmpty()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaEnRiesgoDTO> findRiskPerson() {
        return covidService.findRiskPerson();
    }
}
