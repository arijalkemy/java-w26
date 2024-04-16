package com.example.deportistas.controller;

import com.example.deportistas.model.Deporte;
import com.example.deportistas.service.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportesController{

    @Autowired
    IDeporteService deporteService;

    @GetMapping("/findSports")
    @ResponseBody
    public List<Deporte> TodoDeportes() {
        return deporteService.TodoDeportes();
    }

    @GetMapping("/findSport/{nombre}")
    public ResponseEntity<Integer> verDeporte(@PathVariable String nombre) {
        int nivel = deporteService.verDeporte(nombre);
        if (nivel == 0){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nivel, HttpStatus.OK);
    }
}
