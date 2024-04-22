package org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.controllers;

import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.entities.Deporte;
import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.services.IDeporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deportes")
public class DeporteController {
    @Autowired
    IDeporte deporteService;

    @GetMapping("/encontrarDeportes")
    ResponseEntity<List<Deporte>> encontrarDeportes() {
        return ResponseEntity.ok(deporteService.encontrarDeportes());
    }

    @GetMapping("/encontrarDeporte/{deporte}")
    ResponseEntity<Integer> encontrarDeporte(@PathVariable String deporte) {
        return ResponseEntity.ok(deporteService.encontrarDeporte(deporte));
    }
}
