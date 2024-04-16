package org.mercadolibre.covid.controller;

import org.mercadolibre.covid.dto.PersonaDTO;
import org.mercadolibre.covid.entity.Sintoma;
import org.mercadolibre.covid.service.impl.SaludServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SintomaController {

    final SaludServiceImpl saludService;

    public SintomaController(SaludServiceImpl saludService) {
        this.saludService = saludService;
    }

    @GetMapping("/findSymptoms")
    public List<Sintoma> getSintomas() {
        return this.saludService.getSintomas();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSintoma(@PathVariable String name) {
        int gravedad = saludService.getGravedadDeSintoma(name);
        if (gravedad > 0){
            return new ResponseEntity<>(String.valueOf(gravedad), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No encontrado", HttpStatus.OK);
        }
    }

    @GetMapping("/findRiskPerson")
    @ResponseBody
    public List<PersonaDTO> getPersonasDeRiesgo(){
        return saludService.getPersonasDeRiesgo();
    }
}
