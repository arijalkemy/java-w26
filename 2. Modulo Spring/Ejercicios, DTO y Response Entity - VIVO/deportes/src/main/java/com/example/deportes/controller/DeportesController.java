package com.example.deportes.controller;

import com.example.deportes.dto.SportsPersonsDTO;
import com.example.deportes.entity.Deporte;
import com.example.deportes.service.ISportService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportesController {

    @Autowired
    ISportService sportService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findAllSports() {
        return ResponseEntity.ok(sportService.findAllSports());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deporte> findSportByName(@PathVariable String name) {
        return ResponseEntity.ok(sportService.findSportByName(name));
    }

    @GetMapping("/findSportPersons")
    public ResponseEntity<List<SportsPersonsDTO>> findSportPersons() {
        return ResponseEntity.ok(sportService.findSportPerson());
    }
}
