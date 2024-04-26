package org.example.covid19.controller;

import org.example.covid19.dto.PersonaDto;
import org.example.covid19.model.Sintoma;
import org.example.covid19.service.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {

    @Autowired
    private IPersona iPersona;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> findSymptom() {
       return new ResponseEntity<>(iPersona.getAllSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<Sintoma> findSymptom(@PathVariable String nombre) {
        return new ResponseEntity<>(iPersona.getSymptomByName(nombre), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDto>> findRiskPerson() {
        return new ResponseEntity<>(iPersona.getRiskPersons(), HttpStatus.OK);
    }


}
