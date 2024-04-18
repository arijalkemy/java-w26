package com.example.calorias.controllers;

import com.example.calorias.DTOs.PlatoDTO;
import com.example.calorias.modelo.Plato;
import com.example.calorias.service.PlatoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plato")
public class PlatoController {

    final PlatoServicio platoServicio;

    public PlatoController(PlatoServicio platoServicio) {
        this.platoServicio = platoServicio;
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<PlatoDTO> getPlatoPorNombre(@PathVariable String nombre){
        return new ResponseEntity<>(platoServicio.obtenerPorNombre(nombre), HttpStatus.OK);
    }


}
