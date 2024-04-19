package com.example.covid19.controllers;

import com.example.covid19.dto.PersonaDTO;
import com.example.covid19.models.Sintoma;
import com.example.covid19.services.CovidServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {
    @Autowired
    private CovidServicesImpl covidServices;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> mostrarTodosLosSintomas(){
        return ResponseEntity.ok(covidServices.listarSintomas());
    }

    @GetMapping("/findSymptom/{nombreSintoma}")
    public ResponseEntity<?> consultarSintoma(@PathVariable String nombreSintoma){
        String nivelGravedad = covidServices.consultarSintoma(nombreSintoma);
        if (nivelGravedad != null){
            return ResponseEntity.ok(nivelGravedad);
        }
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> mostrarPersonasRiesgo(){
        return ResponseEntity.ok(covidServices.buscarPersonasDeRiesgo());
    }

}
