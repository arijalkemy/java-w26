package org.example.covid.controller;

import org.example.covid.model.PersonaSintomaDTO;
import org.example.covid.model.SintomaDTO;
import org.example.covid.service.ICovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/covid")
public class CovidController {

    @Autowired
    ICovidService covidService;

    @GetMapping("/findSymptom")
    @ResponseBody
    public List<SintomaDTO> findSymptom() {
        return covidService.verSintomas();
    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<Integer> findSymptom(@PathVariable String nombre) {
        return new ResponseEntity<>(covidService.verSintoma(nombre).getNivelDeGravedad(), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    @ResponseBody
    public List<PersonaSintomaDTO> findRiskPerson() {
        return covidService.verPersonasDeRiesgo();
    }


}
