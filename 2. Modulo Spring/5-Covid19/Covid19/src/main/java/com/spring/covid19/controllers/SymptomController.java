package com.spring.covid19.controllers;

import com.spring.covid19.dtos.SymptomDTO;
import com.spring.covid19.services.ISymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("findSymptom")
public class SymptomController {
    @Autowired
    ISymptomService symptomService;

    @GetMapping
    public ResponseEntity<List<SymptomDTO>> getAllSymptoms(){
        return ResponseEntity.ok(symptomService.getAll());
    }
    @GetMapping("/{name}")
    public ResponseEntity<SymptomDTO> getByName(@PathVariable String name){
        return ResponseEntity.ok(symptomService.getByName(name));
    }
}
