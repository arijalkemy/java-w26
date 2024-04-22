package com.covid19.ejerciciocovid19.controller;


import com.covid19.ejerciciocovid19.dto.PersonaDto;
import com.covid19.ejerciciocovid19.dto.SintomaDto;
import com.covid19.ejerciciocovid19.model.Sintoma;
import com.covid19.ejerciciocovid19.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    Repository repository = new Repository();

    @GetMapping("/findSymptom")
    public List<Sintoma> getSymptom(){
        return repository.getListaSintomas();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDto> getSymptomByName(@PathVariable String name){
        Sintoma sintomaEncontrado = repository.getSintoma(name);
        if(sintomaEncontrado != null){
            SintomaDto sintoma = new SintomaDto(sintomaEncontrado.getNombre(),sintomaEncontrado.getNivelGravedad());
            return ResponseEntity.ok(sintoma);
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity< List<PersonaDto>> getRiskPerson(){
        List<PersonaDto> personaSintomas = repository.getPersonaSintomas();
        if(personaSintomas != null && !personaSintomas.isEmpty()){
            return ResponseEntity.ok(personaSintomas);
        }
        return ResponseEntity.notFound().build();
    }









}
