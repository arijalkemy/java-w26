package com.ejercicio.deportistas.controllers;

import com.ejercicio.deportistas.entities.Sport;
import com.ejercicio.deportistas.services.interfaces.ISportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sports")
public class SportController {
    @Autowired
    ISportsService sportsService;

    @GetMapping("/findSports")
    @ResponseBody
    public ResponseEntity<List<Sport>> getAllSports() {
        return ResponseEntity
                .status(200)
                .body(sportsService.getAllSports());
    }

    @GetMapping("/findSports/{name}")
    @ResponseBody
    public ResponseEntity<?> getAllSports(@PathVariable String name) {
        Sport result = sportsService.getSportByName(name);
        if (result != null) return new ResponseEntity<>(result, HttpStatus.OK);
        return ResponseEntity
                .status(400)
                .body("No se encontraron resultados para el deporte ingresado");
    }
}
