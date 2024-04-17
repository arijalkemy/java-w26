package com.example.ejdeportevivo.controllers;

import com.example.ejdeportevivo.dtos.DeporteDTO;
import com.example.ejdeportevivo.modelo.Deporte;
import com.example.ejdeportevivo.servicios.impl.DeportesServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DeportesController {

    DeportesServiceImpl deportesService;


    public DeportesController(DeportesServiceImpl deportesService){
        this.deportesService = deportesService;
    }

    @GetMapping("/findSports")
    public List<DeporteDTO> obtenerDeportes(){
        return deportesService
                .obtenerTodosLosDeportes()
                .stream()
                .map(d -> new DeporteDTO(d.getNombre(), d.getNivel()))
                .toList();
    }

    @GetMapping("/findSports/{nombre}")
    public ResponseEntity<DeporteDTO> obtenerDeportePorNombre(@PathVariable String nombre){

        Optional<Deporte> deporteBuscado = deportesService.obtenerDeportePorNombre(nombre);

        if(deporteBuscado.isPresent()){
            DeporteDTO deporteDTO = new DeporteDTO(deporteBuscado.get().getNombre(), deporteBuscado.get().getNivel());
            return new ResponseEntity<DeporteDTO>(deporteDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
