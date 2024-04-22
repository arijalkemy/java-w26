package org.example.covid19.controllers;

import org.example.covid19.services.ISintomasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SintomasController {

    @Autowired
    ISintomasService sintomasService;

    @GetMapping("/findSymptom")
    ResponseEntity<?> verSintomas() {
        return new ResponseEntity<>(sintomasService.obtenerListaDeSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{symptom}")
    ResponseEntity<?> buscarSintoma(@PathVariable String symptom) {
        return new ResponseEntity<>(sintomasService.obtenerSintomaPorNombre(symptom), HttpStatus.OK);
    }
}
