package com.dtoEntityDeportistasParte2.parte2.controllers;

import com.dtoEntityDeportistasParte2.parte2.dto.DepostistaDTO;
import com.dtoEntityDeportistasParte2.parte2.entity.Deporte;
import com.dtoEntityDeportistasParte2.parte2.services.interfaces.IDeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistaController {
    @Autowired
    IDeportistaService deportistaService;

    @GetMapping("/findSports")
    ResponseEntity<List<Deporte>> findAll() {
        //return deportistaService.findAll();
        //return new ResponseEntity<>(deportistaService.findAll(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok().header("j").body(deportistaService.findAll());

    }

    @GetMapping("/findSport/{name}")
    ResponseEntity<String> findSport(@PathVariable String name) {
        return ResponseEntity.ok().header("dsds").body(deportistaService.findSport(name));
    }

    @GetMapping("/findSportsPersons")
    public List<DepostistaDTO> findSportsPersons() {
        return deportistaService.findSportsPersons();
    }
}
