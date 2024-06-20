package com.example.deportista.controller;


import com.example.deportista.entities.Deporte;
import com.example.deportista.service.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("deportes/")
public class DeporteController {

    IDeporteService iDeporteService;

    @Autowired
    DeporteController(IDeporteService iDeporteService){
        this.iDeporteService = iDeporteService;
    }

    @GetMapping("ping")
    public String pingPong(){
        return "Pong!!";
    }

    @GetMapping("findSports")
    public ResponseEntity<List<Deporte>> obtenerDeportes(){
        return ResponseEntity.ok(iDeporteService.ObtenerDeportes());
    }

    @GetMapping("findSports/{nombre}")
    public ResponseEntity<Deporte> obtenerDeportePorNombre(@PathVariable String nombre){
        return ResponseEntity.ok(iDeporteService.obtenerDeportePorNombre(nombre));
    }

}
