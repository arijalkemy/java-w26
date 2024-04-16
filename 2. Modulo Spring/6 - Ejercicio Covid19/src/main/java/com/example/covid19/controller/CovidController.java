package com.example.covid19.controller;

import com.example.covid19.clases.Sintoma;
import com.example.covid19.dto.PersonaDto;
import com.example.covid19.service.ICovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/covid")
public class CovidController {

    @Autowired
    ICovidService covidService;

    @GetMapping("/findSymptom")
    @ResponseBody
    public List<Sintoma> obtenerSintomas(){
        return covidService.obtenerSintomas();
    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity buscarSintoma(@PathVariable String nombre ){

        int gravedad = covidService.nivelGravedad( nombre );

        if( gravedad < 0 ){
            return new ResponseEntity("No se encontró el sintoma", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity( gravedad, HttpStatus.OK );
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity buscarPersonasDeRiesgo(){

        List<PersonaDto> personas = covidService.buscarPersonasDeRiesgo();

        if( personas == null ){
            return new ResponseEntity("No se encontraron personas de riesgo", HttpStatus.OK);
        }
        return new ResponseEntity( personas, HttpStatus.OK );
    }
}
