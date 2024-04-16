package org.ejercicio.personasdeportes.controller;

import org.ejercicio.personasdeportes.model.Deporte;
import org.ejercicio.personasdeportes.model.dto.DeportistaDTO;
import org.ejercicio.personasdeportes.service.Deportistarepository;
import org.ejercicio.personasdeportes.service.SportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class DeportesController {

    SportRepository sportRepository = new SportRepository();
    Deportistarepository deportistarepository = new Deportistarepository();


    @GetMapping("findSports")
    public ResponseEntity<List<Deporte>> findSports(){
        return new ResponseEntity<>(sportRepository.findSports(), HttpStatus.OK);
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name){
        String nivel = sportRepository.findSport(name);
        if(nivel.isEmpty()) return ResponseEntity.badRequest().body("Nivel no encontrado");
        return new ResponseEntity<>(sportRepository.findSport(name), HttpStatus.OK);
    }

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons(){
        return new ResponseEntity<>(deportistarepository.findSportsPersons(), HttpStatus.OK);
    }
}
