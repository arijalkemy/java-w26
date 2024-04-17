package meli.bootcamp.covid19.controllers;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.covid19.entities.Symptom;
import meli.bootcamp.covid19.services.SymptomImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/symptom")
@RequiredArgsConstructor
public class SymptonController {
    private final SymptomImpl symptom;

    @GetMapping("/all")
    public ResponseEntity<List<Symptom>> getAllSymptoms() {
        return ResponseEntity.ok(symptom.getAll());
    }

    @GetMapping("/find")
    public ResponseEntity<String> findSymptomById(@RequestParam("name") String name) {
        return ResponseEntity.ok(symptom.getOne(name).getSeverity());
    }
}
