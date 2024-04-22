package com.example.multicapatemplate.controller;

import com.example.multicapatemplate.dto.IngredienteDto;
import com.example.multicapatemplate.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class CaloriasController {

    @Autowired
    RestauranteService restauranteService;

    @GetMapping("/calorias/{plato}")
    public ResponseEntity obtenerCalorias(@PathVariable String plato){
        return new ResponseEntity( restauranteService.obtenerCalorias(plato), HttpStatus.OK);
    }

    @GetMapping("/ingredientes/{plato}")
    public ResponseEntity otenerIngredientes(@PathVariable String plato){

        List<IngredienteDto> ingredientes = restauranteService.obtenerIngredientes(plato);

        if( ingredientes == null ){
            return new ResponseEntity( "No se econtró", HttpStatus.OK);
        }

        return new ResponseEntity(  ingredientes, HttpStatus.OK);
    }

    @GetMapping("/calorico/{plato}")
    public ResponseEntity otenerCalorico(@PathVariable String plato){

        String ingrediente = restauranteService.ingredienteCalorico(plato);

        if( ingrediente == null ){
            return new ResponseEntity( "No se econtró", HttpStatus.OK);
        }

        return new ResponseEntity(  ingrediente, HttpStatus.OK);
    }
}
