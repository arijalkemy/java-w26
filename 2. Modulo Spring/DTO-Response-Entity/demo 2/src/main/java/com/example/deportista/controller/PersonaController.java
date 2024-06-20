package com.example.deportista.controller;

import com.example.deportista.entities.Persona;
import com.example.deportista.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("personas/")
public class PersonaController {

    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("getAll")
    ResponseEntity<List<Persona>> obtenerPersonas(){
        return ResponseEntity.ok(iPersonaService.obtenerPersonas());
    }
}
