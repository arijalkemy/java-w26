package com.example.EjercicioCovid.controllers;

import com.example.EjercicioCovid.dto.PersonaDTO;
import com.example.EjercicioCovid.dto.SintomaDTO;
import com.example.EjercicioCovid.services.SaludService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaludController {

    private final SaludService saludService;

    @Autowired
    public SaludController(SaludService saludService) {
        this.saludService = saludService;
    }

    @GetMapping("/findSymptom")
    public List<SintomaDTO> findAllSymptoms() {
        return saludService.findAllSymptoms();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSymptomByName(@PathVariable String name) {
        String response = saludService.findSymptomByName(name);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaDTO> findHighRiskPersons() {
        return saludService.findHighRiskPersons();
    }
}