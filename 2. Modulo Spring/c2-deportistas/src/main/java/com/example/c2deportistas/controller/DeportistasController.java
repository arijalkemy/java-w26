package com.example.c2deportistas.controller;

import com.example.c2deportistas.domain.Deporte;
import com.example.c2deportistas.service.IDeportistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistasController {

    @Autowired
    IDeportistasService deportistasService;

    @GetMapping("/findSports")
    public ResponseEntity<?> consultaDeportes(){
        return new ResponseEntity<>(deportistasService.consultarDeportes(),HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> existeDeporte(@PathVariable String name){
        return new ResponseEntity<>(deportistasService.existeDeporte(name),HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> visualizarPersonasDeportistas(){
        return new ResponseEntity<>(deportistasService.consultarPersonaDeportista(),HttpStatus.OK);
    }
}
