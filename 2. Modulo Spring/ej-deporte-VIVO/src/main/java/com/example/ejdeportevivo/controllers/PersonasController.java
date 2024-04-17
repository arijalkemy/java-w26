package com.example.ejdeportevivo.controllers;

import com.example.ejdeportevivo.dtos.DeporteDTO;
import com.example.ejdeportevivo.dtos.PersonasDeportivasDTO;
import com.example.ejdeportevivo.modelo.Persona;
import com.example.ejdeportevivo.servicios.impl.PersonasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PersonasController {

    private final PersonasServiceImpl personasService;

    public PersonasController(PersonasServiceImpl personasService) {
        this.personasService = personasService;
    }


    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonasDeportivasDTO>> obtenerPersonasDeportivas(){

        List<Persona> personas = personasService.obtenerTodasLasPersonas();

        return new ResponseEntity<List<PersonasDeportivasDTO>>(personas
                .stream()
                .map(p -> new PersonasDeportivasDTO(p.getNombre(),
                        p.getApellido(),
                        new DeporteDTO(p.getDeporte().getNombre(), p.getDeporte().getNivel())))
                .toList(), HttpStatus.OK);
    }

}
