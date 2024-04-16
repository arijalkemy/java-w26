package com.demospring.deportes.controllers;

import com.demospring.deportes.entities.Deporte;
import com.demospring.deportes.dtos.PersonaDeporteDTO;
import com.demospring.deportes.services.IDeportes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportesController {
    @Autowired
    IDeportes servicesDeportes;

    @GetMapping(path = "/findSports")
    @ResponseBody
    public List<Deporte> findSports() {
        return servicesDeportes.getDeportes();
    }

    @GetMapping(path = "/findSports/{name}")
    public ResponseEntity<Deporte> findSports(@PathVariable String name) {
        return new ResponseEntity<>(servicesDeportes.getDeporte(name), HttpStatus.OK);
    }

    @GetMapping(path = "/findSportsPersons")
    @ResponseBody
    public List<PersonaDeporteDTO> findSportsPersons() {
        return servicesDeportes.getDeportesPersonas();
    }
}
