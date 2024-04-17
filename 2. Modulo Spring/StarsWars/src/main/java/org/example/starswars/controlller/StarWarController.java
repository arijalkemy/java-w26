package org.example.starswars.controlller;


import org.example.starswars.DTO.PersonajeDTO;
import org.example.starswars.Model.Personaje;
import org.example.starswars.service.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarController {
    @Autowired
    StarWarsService starWarsService;

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> getChacaracters(@PathVariable String nombre){
        return ResponseEntity.ok(starWarsService.buscarPersonajePorNombre(nombre));
    }


}
