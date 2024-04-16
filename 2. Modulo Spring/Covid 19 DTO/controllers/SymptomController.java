package org.example.api.controllers;

import org.example.api.entities.Symptom;
import org.example.api.services.ISymptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/symptom")
public class SymptomController {
    private final ISymptom iSymptom;

    public SymptomController(@Autowired ISymptom iSymptom) {
        this.iSymptom = iSymptom;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Symptom>> findAllSymtom() {
        return ResponseEntity.ok().body(this.iSymptom.findAllSymptom());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Symptom> getInstance(@PathVariable String name) {
        return ResponseEntity.ok().body(this.iSymptom.findSymptomByname(name));
    }
}
