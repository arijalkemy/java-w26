package org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.controllers;

import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.dto.DeportistaDTO;
import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.services.IDeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistaController {
    @Autowired
    IDeportistaService deportistaService;

    @GetMapping("/encontrarDeportista")
    ResponseEntity<List<DeportistaDTO>> encontrarDeportista() {
        return ResponseEntity.ok(deportistaService.encontrarDeportistas());
    }
}
