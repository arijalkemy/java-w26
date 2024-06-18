package org.example.ejerciciocovid.controller;

import org.example.ejerciciocovid.dto.RiskPersonDTO;
import org.example.ejerciciocovid.model.Sintoma;
import org.example.ejerciciocovid.service.SaludService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SaludController {

    private final SaludService saludService;

    public SaludController(SaludService saludService) {
        this.saludService = saludService;
    }

    @GetMapping("/findSymptom")
    public List<Sintoma> findAllSymptoms() {
        return saludService.findAllSymptoms();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Integer> findSymptomByName(@PathVariable String name) {
        Sintoma sintoma = saludService.findSymptomByName(name);

        if (sintoma != null) {
            return new ResponseEntity<>(sintoma.getNivelDeGravedad(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findRiskPerson")
    public List<RiskPersonDTO> findRiskPersons() {
        return saludService.findRiskPersons();
    }
}

