package com.deportista.ejerciciodeportistas.controllers;

import com.deportista.ejerciciodeportistas.models.Deporte;
import com.deportista.ejerciciodeportistas.models.dto.PersonaDTO;
import com.deportista.ejerciciodeportistas.service.IDeportes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Deportistas")
public class DeportistasRestController {

    @Autowired
    IDeportes DeportesImpl;

    @GetMapping("/ping")
    public String chequeo(){
        return "PONG";
    }

    @GetMapping("/mostrarDeportes")
    public String getDeportes(){
        return DeportesImpl.verDeportes();
    }

    @GetMapping("/mostrarDeporte/{nombreDeporte}")
    public ResponseEntity<Deporte> getDeportePorNombre(@PathVariable String nombreDeporte){
        return ResponseEntity.ok().body(DeportesImpl.chequearDeportes(nombreDeporte));
    }

    @GetMapping("/mostrarDeportistas")
    public ResponseEntity<List<PersonaDTO>> getDeportistas(){
        return ResponseEntity.ok().body(DeportesImpl.verDeportistas());
    }
}
