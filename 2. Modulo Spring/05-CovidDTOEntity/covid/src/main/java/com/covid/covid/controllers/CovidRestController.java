package com.covid.covid.controllers;


import com.covid.covid.models.Sintoma;
import com.covid.covid.models.dto.PersonasRiesgoDTO;
import com.covid.covid.models.dto.SintomaDTO;
import com.covid.covid.services.CovidImpl;
import com.covid.covid.services.ICovid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/covid")
public class CovidRestController {

    @Autowired
    ICovid CovidImpl;

    @GetMapping("/ping")
    public String chequeoApi(){
        return "pong";
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> getSintomas(){
        return ResponseEntity.ok().body(CovidImpl.getSintomas());
    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<SintomaDTO> getSintomaNombre(@PathVariable String nombre){
        return ResponseEntity.ok().body(CovidImpl.getSintomaPorNombre(nombre));
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonasRiesgoDTO>> getPersonasRiesgo(){
        return ResponseEntity.ok().body(CovidImpl.getPersonasRiesgo());
    }
}
