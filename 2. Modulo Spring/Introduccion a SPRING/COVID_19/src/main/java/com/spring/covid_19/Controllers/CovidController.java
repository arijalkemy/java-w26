package com.spring.covid_19.Controllers;

import com.spring.covid_19.Dtos.RiskPersonDto;
import com.spring.covid_19.Models.Sintoma;
import com.spring.covid_19.Services.ICovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CovidController {

    @Autowired
    ICovidService covidService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> findSymptoms(){
        List<Sintoma> sintomas = covidService.findSymptoms();
        return new ResponseEntity<>(sintomas, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Optional<Sintoma>> findSymptom(@PathVariable String name){
        Optional<Sintoma> sintoma = covidService.findSymptom(name);
        return new ResponseEntity<>(sintoma, HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonDto>> findRiskPerson(){
        List<RiskPersonDto> riskPersonDtos = covidService.findRiskPersons();
        return new ResponseEntity<>(riskPersonDtos, HttpStatus.OK);
    }
}
