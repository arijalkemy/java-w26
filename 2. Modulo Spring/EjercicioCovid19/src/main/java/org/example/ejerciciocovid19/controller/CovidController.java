package org.example.ejerciciocovid19.controller;

import org.example.ejerciciocovid19.dto.PatientDTO;
import org.example.ejerciciocovid19.dto.SymptomDTO;
import org.example.ejerciciocovid19.service.ICovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/covid")
public class CovidController {
    @Autowired
    private ICovidService covidService;

    @GetMapping("/findSymptoms")
    public List<SymptomDTO> findSymptoms(){
        return covidService.searchAllSymptoms();
    }
    @GetMapping("/findSymptom/{name}")
    public int findSymptom(@PathVariable String name){
        return covidService.searchSymptom(name);
    }

    @GetMapping("/findRiskPersons")
    public List<PatientDTO> findRiskPersons(){
        return covidService.searchPatientsBySymptom();
    }

}
