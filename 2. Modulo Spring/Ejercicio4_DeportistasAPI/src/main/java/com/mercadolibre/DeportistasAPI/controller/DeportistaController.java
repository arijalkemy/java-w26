package com.mercadolibre.DeportistasAPI.controller;

import com.mercadolibre.DeportistasAPI.DTO.PersonaDTO;
import com.mercadolibre.DeportistasAPI.model.Deporte;
import com.mercadolibre.DeportistasAPI.services.IDeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/deportes")
public class DeportistaController {

    @Autowired
     IDeportistaService deportistaService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getAllSports() {
        return ResponseEntity.status(HttpStatus.OK).body(deportistaService.obtDeportes());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> ConsultarDeporte(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(deportistaService.obtDeportePorNombre(name));
    }
}
