package com.javabootcamp.apideportes.controller;

import com.javabootcamp.apideportes.dto.Deporte;
import com.javabootcamp.apideportes.dto.Persona;
import com.javabootcamp.apideportes.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportesController {

    @Autowired
    DeporteService deporteService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports() {
        return ResponseEntity.ok(deporteService.muestraTodosDeportes());
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> findSportByName(@PathVariable  String name) {
        return ResponseEntity.ok(deporteService.findSportByName(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<Persona>> findPersons(){
        return ResponseEntity.ok(deporteService.findAllPersons());
    }
}
