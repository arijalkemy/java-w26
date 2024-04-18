package com.EjercicioSpring.Ejercicio7_Covid19.controller;

import com.EjercicioSpring.Ejercicio7_Covid19.dto.PersonaAltoRiesgoDTO;
import com.EjercicioSpring.Ejercicio7_Covid19.dto.SintomaDTO;
import com.EjercicioSpring.Ejercicio7_Covid19.service.SintomasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CovidController {

    private SintomasService sintomasService = new SintomasService();

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> getSintomas() {
        List<SintomaDTO> sintomas = sintomasService.getSintomas();
        if (sintomas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(sintomas);
        }
        return ResponseEntity.status(HttpStatus.OK).body(sintomas);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> getNivelGravedad(@PathVariable String name) {
        String nivelGravedad = sintomasService.getSintomaByName(name);
        if (nivelGravedad.equals("No se encontró el síntoma")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(nivelGravedad);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaAltoRiesgoDTO>> getPersonasAltoRiesgo() {
        List<PersonaAltoRiesgoDTO> personas = sintomasService.getPersonasAltoRiesgo();
        if (personas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personas);
        }
        return ResponseEntity.status(HttpStatus.OK).body(personas);
    }

}
