package org.ejercicio.personasdeportes.controller;

import org.ejercicio.personasdeportes.model.Deporte;
import org.ejercicio.personasdeportes.model.dto.DeportistaDTO;
import org.ejercicio.personasdeportes.service.DeportistaRepository;
import org.ejercicio.personasdeportes.service.DeporteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class DeportesController {

    DeporteRepository deporteRepository = new DeporteRepository();
    DeportistaRepository deportistaRepository = new DeportistaRepository();


    @GetMapping("findSports")
    public ResponseEntity<List<Deporte>> findSports(){
        return new ResponseEntity<>(deporteRepository.findSports(), HttpStatus.OK);
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name){
        String nivel = deporteRepository.findSport(name);
        if(nivel.isEmpty()) return ResponseEntity.badRequest().body("Nivel no encontrado");
        return new ResponseEntity<>(deporteRepository.findSport(name), HttpStatus.OK);
    }

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons(){
        return new ResponseEntity<>(deportistaRepository.findDeportePersona(), HttpStatus.OK);
    }
}
