package com.spring.covid19.controllers;

import com.spring.covid19.models.Symptom;
import com.spring.covid19.models.dto.RiskPersonDTO;
import com.spring.covid19.services.ISymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/findSymptom")
public class SymptomController {

    private final ISymptomsService symptomsService;

    @Autowired
    public SymptomController(ISymptomsService symptomsService) {
        this.symptomsService = symptomsService;
    }

    @GetMapping
    public List<Symptom> getAllSymptoms() {
        return symptomsService.getAllSymptoms();
    }

    @GetMapping("/{name}")
    ResponseEntity<Integer> getRiskLevelBySymptomName(@PathVariable String name) {
        Integer riskLevel = symptomsService.getRiskLevelBySymptomName(name);
        // Pruebo usarlo de otras formas
        if(riskLevel != null){
            return new ResponseEntity<>(symptomsService.getRiskLevelBySymptomName(name), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

}
