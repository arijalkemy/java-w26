package com.meli.Covid19.controller;

import com.meli.Covid19.models.Sintoma;
import com.meli.Covid19.dto.PersonaDeRiesgoDTO;
import com.meli.Covid19.service.ISintomaService;
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
    private ISintomaService service;

    @GetMapping("/")
    public List<Sintoma> buscarSintomas(){
        return service.buscarSintomas();
    }

    @GetMapping("/gravedad/{nombre}")
    public ResponseEntity<String> buscarNivelDeGravedad(@PathVariable String nombre){
        return ResponseEntity.ok(service.buscarNivelDeGravedad(nombre));
    }

    @GetMapping("/personasDeRiesgo")
    public List<PersonaDeRiesgoDTO> buscarPersonasDeRiesgo(){
        return service.buscarPersonasDeRiesgo();
    }
}
