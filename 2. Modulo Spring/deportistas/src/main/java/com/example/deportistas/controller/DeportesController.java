package com.example.deportistas.controller;

import com.example.deportistas.dto.DeporteDTO;
import com.example.deportistas.dto.PersonaDTO;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.service.IDeportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deportes")
public class DeportesController {

    @Autowired
    private IDeportesService deportesService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports(){
        return new ResponseEntity<>(deportesService.findSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> findSport(@PathVariable String name){
        return new ResponseEntity<>(deportesService.findSport(name), HttpStatus.OK);
    }

    @GetMapping("/sportPerson")
    public ResponseEntity<List<PersonaDTO>> findSportPerson(){
        return new ResponseEntity<>(deportesService.findSportsByPersons(), HttpStatus.OK);
    }
}
