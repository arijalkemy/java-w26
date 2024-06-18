package org.example.ejerciciodeportistas.controller;
import org.example.ejerciciodeportistas.dto.DeportistaDTO;
import org.example.ejerciciodeportistas.model.Deporte;
import org.example.ejerciciodeportistas.service.DeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeporteController {

    private final DeporteService deporteService;

    public DeporteController(DeporteService deporteService) {
        this.deporteService = deporteService;
    }

    @GetMapping("/findSports")
    public List<Deporte> findAllSports() {
        return deporteService.findAllSports();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSportByName(@PathVariable String name) {
        Deporte deporte = deporteService.findSportByName(name);

        if (deporte != null) {
            return new ResponseEntity<>(deporte.getNivel(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSportsPersons")
    public List<DeportistaDTO> findSportsPersons() {
        return deporteService.findSportsPersons();
    }
}

