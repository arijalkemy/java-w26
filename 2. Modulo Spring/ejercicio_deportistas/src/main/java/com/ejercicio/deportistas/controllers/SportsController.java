package com.ejercicio.deportistas.controllers;

import com.ejercicio.deportistas.models.Sport;
import com.ejercicio.deportistas.services.interfaces.ISportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportsController {
    @Autowired
    ISportsService sportsService;

    @GetMapping("/findSports")
    @ResponseBody
    public List<Sport> getAllSports() {
        return sportsService.getAllSports();
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
