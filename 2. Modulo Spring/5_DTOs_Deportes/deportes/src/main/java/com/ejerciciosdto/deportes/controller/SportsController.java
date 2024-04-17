package com.ejerciciosdto.deportes.controller;

import com.ejerciciosdto.deportes.models.Deporte;
import com.ejerciciosdto.deportes.service.IDeporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SportsController {
    @Autowired
    IDeporte serviceDeporte;
    @GetMapping(path = "/getDeportes")
    @ResponseBody
    public List<Deporte> getDeportes() {
        return serviceDeporte.findSports();
    }

    @GetMapping(path = "/getDeportes/{name}")
    @ResponseBody
    public ResponseEntity<String> getDeporte(@PathVariable String name) {
        return new ResponseEntity<>("El deporte "+ name +" tiene una dificultad "+serviceDeporte.findSportByName(name),HttpStatus.OK);
    }

}
