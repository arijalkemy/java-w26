package org.bootcamp.ejerciciodeportistas.controller;

import org.bootcamp.ejerciciodeportistas.service.DeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sports")
public class DeporteController {

    private DeporteService deporteService;

    public DeporteController(DeporteService deporteService) {
        this.deporteService = deporteService;
    }

    @GetMapping("findSports")
    public ResponseEntity<?> findAllSports(){
        return new ResponseEntity<>(deporteService.obtenerDeportes(), HttpStatus.OK);
    }
    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findAllSports(@PathVariable("name")String nombre){
        return new ResponseEntity<>(deporteService.obtenerDeportePorNombre(nombre), HttpStatus.OK);
    }
}
