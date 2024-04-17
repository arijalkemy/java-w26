package com.meli.bootcamp.EjercicioDeportistas.controller;

import com.meli.bootcamp.EjercicioDeportistas.dto.DeportistaDTO;
import com.meli.bootcamp.EjercicioDeportistas.model.Deporte;
import com.meli.bootcamp.EjercicioDeportistas.service.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeportesController {

    @Autowired
    private Servicio deportesServicio;

    @GetMapping("/findSports")
    public List<Deporte> findAllSports() {
        return deportesServicio.findAllSports();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deporte> findSportByName(@PathVariable String name) {
        Deporte deporte = deportesServicio.findSportByName(name);
        if (deporte != null) {
            return ResponseEntity.ok(deporte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findSportsPersons")
    public List<DeportistaDTO> findAllSportsPersons() {
        return deportesServicio.findAllSportsPersons();
    }
}
