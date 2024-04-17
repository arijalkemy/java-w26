package meli.bootcamp.deportistas.controllers;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.deportistas.dto.PersonSportDto;
import meli.bootcamp.deportistas.entities.Person;
import meli.bootcamp.deportistas.services.PersonaImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonaImpl persona;

    @GetMapping("/findAll")
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(persona.getAll());
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<Person> findByName(@PathVariable String name) {
        return ResponseEntity.ok(persona.getOne(name));
    }

    @GetMapping("/findAllWithSports")
    public ResponseEntity<List<PersonSportDto>> findAllWithSports() {
        return ResponseEntity.ok(persona.getPersonsWithSport());
    }
}
