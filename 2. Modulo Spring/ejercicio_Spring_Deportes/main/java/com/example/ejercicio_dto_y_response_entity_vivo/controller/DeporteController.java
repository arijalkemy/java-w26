package com.example.ejercicio_dto_y_response_entity_vivo.controller;

import com.example.ejercicio_dto_y_response_entity_vivo.api.dto.PersonaDeportistaDTO;
import com.example.ejercicio_dto_y_response_entity_vivo.persistence.model.Deporte;
import com.example.ejercicio_dto_y_response_entity_vivo.persistence.model.Persona;
import com.example.ejercicio_dto_y_response_entity_vivo.service.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deportes")
public class DeporteController {
    @Autowired
    private IDeporteService deporteService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> obtenerDeportes() {
        return new ResponseEntity<>(
                deporteService.getDeportes(),
                HttpStatus.OK
        );
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> consultarDeportePorNombre(
            @PathVariable String name
    ) {
        Optional<Deporte> deporte = deporteService.consultarDeportePorNombre(name);
        if(deporte.isPresent()) {
            return new ResponseEntity<>(
                deporte.get().getNivel(),
                HttpStatus.OK
            );
        } else {
            return new ResponseEntity<>(
                "Deporte no encontrado!",
                HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeportistaDTO>> obtenerPersonasDeportistas() {
        return new ResponseEntity<>(
            deporteService.obtenerPersonasDeportistas(),
            HttpStatus.OK
        );
    }
}
