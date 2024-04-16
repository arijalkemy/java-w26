package com.example.ejerciciodeportistas.controller;
import com.example.ejerciciodeportistas.DTO.DeportistaDto;
import com.example.ejerciciodeportistas.clases.Deporte;
import com.example.ejerciciodeportistas.clases.Deportista;
import com.example.ejerciciodeportistas.service.IDeportistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeportistasController {

    @Autowired
    IDeportistasService deportistasService;

    @GetMapping("/findSports")
    @ResponseBody
    public List<Deporte> obtenerDeportes(){
        return deportistasService.obtenerDeportes();
    }

    @GetMapping("/findSports/{nombre}")
    public ResponseEntity obtenerDeporte(@PathVariable String nombre ){
        Deporte deporte = deportistasService.obtenerDeporte( nombre );

        if( deporte == null ){
            return new ResponseEntity("No se encontró el deporte", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity( "Nivel: " + deporte.getNivel(), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    @ResponseBody
    public List<DeportistaDto> obtenerDeportistas( ){
        List<Deportista> deportistas = deportistasService.obtenerDeportistas();
        List<DeportistaDto> deportistasDto = new ArrayList<>();

        deportistas.forEach( d -> {
            DeportistaDto deportistaDto = new DeportistaDto();
            deportistaDto.setApellido( d.getApellido());
            deportistaDto.setNombre( d.getNombre());
            deportistaDto.setNombreDeporte( d.getDeporte().getNombre());
            deportistasDto.add( deportistaDto );
        });
        return deportistasDto;
    }
}