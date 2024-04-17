package org.ggomezr.deportistas.application.controller;

import org.ggomezr.deportistas.application.service.impl.DeporteService;
import org.ggomezr.deportistas.application.service.impl.PersonaService;
import org.ggomezr.deportistas.domain.dto.PersonaDTO;
import org.ggomezr.deportistas.domain.entity.Deporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {

    @Autowired
    private DeporteService deporteService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports(){
        List<Deporte> deportes = deporteService.findSports();
        if(!deportes.isEmpty()) return new ResponseEntity<>(deportes, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deporte> findSportByName(@PathVariable String name){
        Deporte deporte = deporteService.findSportByName(name);
        if(deporte != null) return new ResponseEntity<>(deporte, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
