package com.w26.covid19.controller;

import com.w26.covid19.service.IFindSymptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medical")
public class SymptomController {

    final IFindSymptService findSymptService;

    public SymptomController(IFindSymptService findSymptService) {
        this.findSymptService = findSymptService;
    }

    @GetMapping(value = {"/findSymptom", "/findSymptom/{name}"})
    public ResponseEntity<?> getSymptom(@PathVariable(required = false) String name)
    {
        if (name == null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(findSymptService.findAllSympt());
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(findSymptService.findByName(name));
    }
}
