package com.example.covid.controller;

import com.example.covid.dto.Riesgo;
import com.example.covid.entity.Sintoma;
import com.example.covid.service.SintomaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sintoma")
public class SintomaController {

    @Autowired
    SintomaServiceImpl sintomaService;

    @GetMapping("/findSymptom")
    public List<Sintoma> findSymptom(){
        return sintomaService.todosLosSintomas();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSymptomByName(@PathVariable String name){
        if(sintomaService.existeSintoma(name) == null)
            return new ResponseEntity<>("No existe el sintoma", HttpStatus.NOT_FOUND);
        return new ResponseEntity<String>(""+sintomaService.existeSintoma(name).getNivel_de_gravedad(), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public List<Riesgo> findRiskPerson(){
        return sintomaService.personasRiesgo();
    }

}
