package com.example.EjercicioDeporte.controllers;

import com.example.EjercicioDeporte.dto.PersonaDTO;
import com.example.EjercicioDeporte.services.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IDeporteService desporteService;

    @GetMapping("/")
    public ResponseEntity<List<PersonaDTO>> buscarDesportistas(){
        return ResponseEntity.ok(desporteService.buscarPersonasDeportistas());
    }
}
