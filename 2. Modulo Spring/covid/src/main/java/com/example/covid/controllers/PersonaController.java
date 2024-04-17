package com.example.covid.controllers;

import com.example.covid.DTOs.PersonaDTO;
import com.example.covid.DTOs.SintomaDTO;
import com.example.covid.modelo.Persona;
import com.example.covid.servicios.IPersonasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonaController {

    private IPersonasService personasService;

    public PersonaController(IPersonasService personasService){
        this.personasService = personasService;
    }

    @GetMapping("findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> obtenerPersonasDeRiesgo(){
        List<Persona> personasDeRiesgo = personasService.personasDeRiesgo();

        List<PersonaDTO> personasDeRiesgoDTOS = new ArrayList<>();

        for(Persona p: personasDeRiesgo){

            List<SintomaDTO> sintomaDTOS =
                    p.getSintomaList()
                            .stream().map(s -> new SintomaDTO(s.getNombre(),s.getNivelDeGravedad()))
                            .toList();

            personasDeRiesgoDTOS.add(
                    new PersonaDTO(p.getNombre(),p.getApellido(),p.getEdad(),sintomaDTOS)
            );
        }

        return new ResponseEntity<>(personasDeRiesgoDTOS, HttpStatus.OK);
    }

}
