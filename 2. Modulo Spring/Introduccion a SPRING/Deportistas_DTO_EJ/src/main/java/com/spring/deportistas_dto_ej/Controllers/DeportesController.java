package com.spring.deportistas_dto_ej.Controllers;

import com.spring.deportistas_dto_ej.Dtos.PersonaDto;
import com.spring.deportistas_dto_ej.Models.Deporte;
import com.spring.deportistas_dto_ej.Services.ISportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DeportesController {

    @Autowired
    ISportsService sportsService;

    @GetMapping("findSports")
    public ResponseEntity<List<Deporte>> findSports(){
            List<Deporte> deportes = sportsService.findSports();
            return ResponseEntity.ok(deportes);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Optional<Deporte>> findSport(@PathVariable String name){
        Optional<Deporte> deporte = sportsService.findSport(name);
        return ResponseEntity.ok(deporte);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDto>> findSportsPersons(){
        List<PersonaDto> personasDto = sportsService.findSportsPersons();
        return ResponseEntity.ok(personasDto);
    }
}
