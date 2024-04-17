package com.ej1p2.covid19.controllers;

import com.ej1p2.covid19.model.Symptom;
import com.ej1p2.covid19.services.ISymptomFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class SymptomController {

    @Autowired
    private ISymptomFinder symptomFinderService;

    @GetMapping("/findSymptom")
    public List<Symptom> findSymptom() {
        return symptomFinderService.findAllSymptoms();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSymptom(@PathVariable String name) {
        String symptomName = symptomFinderService.findSeverityBySymptom(name);
        if (symptomName != null) {
            return ResponseEntity.ok(symptomName);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
