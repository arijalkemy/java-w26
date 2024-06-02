package com.mercadolibre.deportes_n.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.deportes_n.model.Deporte;
import com.mercadolibre.deportes_n.service.ServicioBusquedaDeportes;

import java.util.List;

@RestController
@RequestMapping("/deporte")
public class ControladorDeporte {

    private final ServicioBusquedaDeportes servicioBusqueda;

    public ControladorDeporte(ServicioBusquedaDeportes servicioBusqueda) {
        this.servicioBusqueda = servicioBusqueda;
    }

    @GetMapping(value = {"/encontrarDeportes/{nombre}","/encontrarDeportes/" })
    public ResponseEntity<List<Deporte>> encontrarDeportes(@PathVariable(required = false) String nombre)
    {
        List<Deporte> deportesEncontrados = null;
        if (nombre != null){
            deportesEncontrados = servicioBusqueda.encontrarDeportes(nombre);
        } else {
            deportesEncontrados = servicioBusqueda.encontrarDeportes();
        }
        return new ResponseEntity<>(deportesEncontrados, HttpStatus.OK);
    }
}
