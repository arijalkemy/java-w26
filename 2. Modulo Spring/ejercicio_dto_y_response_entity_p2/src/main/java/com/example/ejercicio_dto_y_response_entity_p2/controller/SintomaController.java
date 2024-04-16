package com.example.ejercicio_dto_y_response_entity_p2.controller;

import com.example.ejercicio_dto_y_response_entity_p2.dto.PersonaRiesgoDTO;
import com.example.ejercicio_dto_y_response_entity_p2.persistence.entity.Sintoma;
import com.example.ejercicio_dto_y_response_entity_p2.service.implementation.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sintomas")
public class SintomaController {
    @Autowired
    private ISintomaService sintomaService;

    @GetMapping("/findSymptoms")
    public ResponseEntity<List<Sintoma>> obtenerSintomas() {
        return new ResponseEntity<>(
            sintomaService.obtenerSintomas(),
            HttpStatus.OK
        );
    }

    @GetMapping("/findSymptoms/{name}")
    public ResponseEntity<String> obtenerGravedadSintoma(
            @PathVariable String name
    ) {
        return new ResponseEntity<>(
            sintomaService.obtenerGravedadSintoma(name),
            HttpStatus.OK
        );
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaRiesgoDTO>> obtenerPersonasRiesgo() {
        return new ResponseEntity<>(
            sintomaService.obtenerPersonasRiesgo(),
            HttpStatus.OK
        );
    }
}

