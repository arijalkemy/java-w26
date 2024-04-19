package com.sinc_ejerciciodeportistas.controlador;

import com.sinc_ejerciciodeportistas.dto.PersonaDeporteDTO;
import com.sinc_ejerciciodeportistas.servicio.IPersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaControlador {

    @Autowired
    private IPersonaServicio iPersonaServicio;

    @GetMapping(path = "/findSportsPersons")
    public ResponseEntity<List<PersonaDeporteDTO>> obtenerPersonasDeportistas () {
        return new ResponseEntity<>(iPersonaServicio.obtenerTodasPersonasDeportistas(), HttpStatus.OK);
    }

    //prueba: localhost:8080/findSportsPersons

}
