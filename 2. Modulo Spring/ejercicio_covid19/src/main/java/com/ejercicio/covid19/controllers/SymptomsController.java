package com.ejercicio.covid19.controllers;

import com.ejercicio.covid19.models.Symptom;
import com.ejercicio.covid19.services.interfaces.ISymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SymptomsController {
    @Autowired
    ISymptomsService symptomsService;

    @GetMapping("/findSymptom")
    public List<Symptom> getAllSymptoms() {
        return symptomsService.getAllSymptoms();
    }

    @GetMapping("/findSymptom/{name}")
    public Symptom getSymptomByName(@PathVariable String name) {
        return symptomsService.getSymptomByName(name);
    }
}
