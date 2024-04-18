package org.example.ejerciciodeportista.controller;

import org.example.ejerciciodeportista.dto.DeporteDTO;
import org.example.ejerciciodeportista.dto.DeportistaDTO;
import org.example.ejerciciodeportista.service.IDeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/deportista")
public class DeportistaController {
    @Autowired
    private IDeportistaService deportistaService;

    @GetMapping("/encontrarDeportes")
    public List<DeporteDTO> obtenerDeportes(){
        return deportistaService.findAllDeportes();
    }

    @GetMapping("/encontrarDeporte/{nombre}")
    public List<DeporteDTO> obtenerDeporte(@PathVariable String nombre){
        return deportistaService.findDeportesByName(nombre);
    }

    @GetMapping("/encontrarDeportistas")
    public List<DeportistaDTO> obtenerDeportistas(){
        return deportistaService.findDeportistas();
    }
}
