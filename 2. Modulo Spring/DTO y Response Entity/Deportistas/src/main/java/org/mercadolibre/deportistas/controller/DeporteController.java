package org.mercadolibre.deportistas.controller;

import org.mercadolibre.deportistas.model.Deporte;
import org.mercadolibre.deportistas.model.DeportistaDTO;
import org.mercadolibre.deportistas.service.impl.DeporteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {
    final DeporteServiceImpl deporteService;
    public DeporteController(DeporteServiceImpl deporteService) {
        this.deporteService = deporteService;
    }
    @GetMapping("/findSports")
    @ResponseBody
    public List<Deporte> getDeportes(){
        return this.deporteService.getDeportes();
    }

    @GetMapping("/findSports/{nombre}")
    public ResponseEntity<String> getNivelDeDeporte(@PathVariable String nombre){
        return new ResponseEntity<>(this.deporteService.getNivelDeDeporte(nombre), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    @ResponseBody
    public List<DeportistaDTO> getDeportistas(){
        return this.deporteService.getDeportistas();
    }
}
