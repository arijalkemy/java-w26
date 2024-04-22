package com.bootcamp.covid19.controller;

import com.bootcamp.covid19.dto.RiskPersonDTO;
import com.bootcamp.covid19.entity.Sintoma;
import com.bootcamp.covid19.service.ICovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {

    @Autowired
    private ICovidService covidService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> findAllSymptoms() {

        return ResponseEntity.ok(covidService.findAllSymptoms());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Sintoma> findSymptomByName(@PathVariable String name) {
        return ResponseEntity.ok(covidService.findSymptomByName(name));
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonDTO>> findRiskPerson() {
        return ResponseEntity.ok(covidService.findRiskPerson());
    }

}
