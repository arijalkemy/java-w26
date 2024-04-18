package com.Ejercicio.Covid.Controller;

import com.Ejercicio.Covid.Entity.Symptom;
import com.Ejercicio.Covid.Service.ISymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/symptomController")
public class SymptomController {
    @Autowired
    ISymptomService iSymptomService;

    @GetMapping("/findSymptoms")
    public List<Symptom> findSymtoms(){
        return iSymptomService.findSymtoms();
    }

    @GetMapping("/findLevelOfSeverity/{name}")
    public ResponseEntity<?> findLevelOfSeverity(@RequestParam String name) {
        Optional<Integer> severityLevel = iSymptomService.findLevelOfSeverityBy(name);
        if (severityLevel.isPresent()) {
            return new ResponseEntity<>(severityLevel.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
}
