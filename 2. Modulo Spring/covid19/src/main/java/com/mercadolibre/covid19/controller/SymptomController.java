package com.mercadolibre.covid19.controller;

import com.mercadolibre.covid19.model.entity.Symptom;
import com.mercadolibre.covid19.service.ISymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "symptom")
public class SymptomController {
    @Autowired
    private ISymptomService symptomService;

    @GetMapping
    public ResponseEntity<List<Symptom>> findAll() {
        return ResponseEntity.ok(symptomService.findAll());
    }
    @GetMapping(path = "{name}/severity")
    public ResponseEntity<String> findByName(@PathVariable String name) {
        return ResponseEntity.ok(symptomService.findSeverityByName(name));
    }
}
