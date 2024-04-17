package org.covid.ejerciciocovid19.controller;

import org.covid.ejerciciocovid19.model.PersonaSintomaDTO;
import org.covid.ejerciciocovid19.model.Sintoma;
import org.covid.ejerciciocovid19.service.IServiceCovid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CovidController {

    @Autowired
    IServiceCovid serviceCovid;

    @GetMapping("/findSymptom")
    @ResponseBody
    public List<Sintoma> getSintomas() {
        return serviceCovid.findSintomas();
    }

    @GetMapping("/findSymptom/{name}")
    @ResponseBody
    public ResponseEntity<Integer> getSintomaByName(@PathVariable String name) {
        //return serviceCovid.findSintomaByName(name);
        return new ResponseEntity<>(serviceCovid.findSintomaByName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPersons")
    @ResponseBody
    public ResponseEntity<List<PersonaSintomaDTO>>  getRiskPersons() {
        return new ResponseEntity<>(serviceCovid.findRiskPersons(), HttpStatus.OK);
    }





}
