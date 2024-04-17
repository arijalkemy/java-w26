package com.javabootcamp.covid19.controller;

import com.javabootcamp.covid19.dto.Persona;
import com.javabootcamp.covid19.dto.Sintoma;
import com.javabootcamp.covid19.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {

    @Autowired
    CovidService covidService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> showAllSymptoms(){
        return ResponseEntity.ok(covidService.getAllSintomas());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Sintoma> findSymptom(@PathVariable String name){
        return ResponseEntity.ok((covidService.findSymptom(name)));
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<Persona>> showAllPersons(){
        return ResponseEntity.ok(covidService.getAllPersonas());
    }
}
