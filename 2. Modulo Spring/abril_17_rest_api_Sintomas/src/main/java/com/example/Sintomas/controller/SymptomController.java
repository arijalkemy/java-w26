package com.example.Sintomas.controller;

import com.example.Sintomas.entity.Symptom;
import com.example.Sintomas.service.ISymptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/symptom")
public class SymptomController {
    @Autowired
    private ISymptom symptomService;


    @GetMapping("/getAll")
    public ResponseEntity<List<Symptom>> getAll() {
        return ResponseEntity.ok(symptomService.getAll());
    }

    @GetMapping("/get")
    public ResponseEntity<Symptom> getById(@RequestParam String symptomName) {
        return ResponseEntity.ok(symptomService.getByName(symptomName));
    }
}
