package com.example.deportista.controller;

import com.example.deportista.entities.Deporte;
import com.example.deportista.service.IDeporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@RestController
@RequestMapping("/v1/")
public class DeporteController {

    IDeporte iDeporte;

    @Autowired
    DeporteController(IDeporte iDeporte){
        this.iDeporte = iDeporte;
    }

    @GetMapping("Ping")
    public String pingPong(){
        return "Pong!!";
    }

    @GetMapping("obtenerDeportes")
    public List<Deporte> obtenerDeportes(){
        return iDeporte.ObtenerDeportes();
    }



}
