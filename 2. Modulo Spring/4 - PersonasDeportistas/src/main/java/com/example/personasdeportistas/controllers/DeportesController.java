package com.example.personasdeportistas.controllers;

import com.example.personasdeportistas.models.Deporte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DeportesController {
    private final List<Deporte> deportes = Arrays.asList(
            new Deporte("Futbol", "Profesional"),
            new Deporte("Tenis", "Amateur"),
            new Deporte("Natacion", "Intermedio"),
            new Deporte("Rugby","Profesional")
    );
    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> buscarTodosDeportes(){
        return ResponseEntity.ok(deportes);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> buscarPorDeporte(@PathVariable String name){
        for(Deporte dep : deportes){
            if (dep.getNombre().equalsIgnoreCase(name)){
                return ResponseEntity.ok(dep.getNivel());
            }
        }
        return new ResponseEntity<>("No se encontro el deporte",HttpStatus.NOT_FOUND);
    }



}
