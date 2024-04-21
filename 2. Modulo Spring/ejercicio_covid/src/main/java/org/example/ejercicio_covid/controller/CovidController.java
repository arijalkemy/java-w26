package org.example.ejercicio_covid.controller;

import org.example.ejercicio_covid.dto.RiskPersonDTO;
import org.example.ejercicio_covid.models.Symptom;
import org.example.ejercicio_covid.services.ICovidSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CovidController {
    @Autowired
    ICovidSevice covidSevice;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Symptom>> getAllSymptoms() {
        return ResponseEntity.ok(covidSevice.findSymptom());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Symptom> getSymptoms(@PathVariable String name) {
        return ResponseEntity.ok(covidSevice.findSymptom(name));
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonDTO>> getRiskPerson(){
        return ResponseEntity.ok(covidSevice.findRiskPerson());
    }
}
