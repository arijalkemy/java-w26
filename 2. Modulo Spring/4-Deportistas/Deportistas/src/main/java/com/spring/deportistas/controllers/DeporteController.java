package com.spring.deportistas.controllers;

import com.spring.deportistas.DTOs.DeportistaDTO;
import com.spring.deportistas.models.Deporte;
import com.spring.deportistas.services.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {
    @Autowired
    IDeporteService deporteService;

    @GetMapping("findSports")
    public List<String> getAll(){
        return deporteService.consultarDeportes();
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<Deporte> findByName(@PathVariable String name) throws Exception {
        return new ResponseEntity<>(deporteService.buscarUnDeporte(name), HttpStatus.OK);
    }
}
