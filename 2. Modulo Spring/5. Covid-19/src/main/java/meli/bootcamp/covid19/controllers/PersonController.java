package meli.bootcamp.covid19.controllers;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.covid19.dto.PersonSymptomDto;
import meli.bootcamp.covid19.entities.Person;
import meli.bootcamp.covid19.services.PersonImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonImpl persons;

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(persons.getAll());
    }

    @GetMapping("/find")
    public ResponseEntity<Person> findPersonByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(persons.getOne(name));
    }

    @GetMapping("/findRiskPersons")
    public ResponseEntity<List<PersonSymptomDto>> findRiskPersons() {
        return ResponseEntity.ok(persons.findRiskPerson());
    }
}
