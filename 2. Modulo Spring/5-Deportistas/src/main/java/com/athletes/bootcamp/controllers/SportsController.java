package com.athletes.bootcamp.controllers;

import com.athletes.bootcamp.classes.Person;
import com.athletes.bootcamp.dtos.PersonDTO;
import com.athletes.bootcamp.classes.Sport;
import com.athletes.bootcamp.services.IPersonsService;
import com.athletes.bootcamp.services.ISportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SportsController {
    @Autowired
    ISportsService sportsService;
    @Autowired
    IPersonsService personsService;

    @GetMapping("/findSports")
    @ResponseBody
    public List<Sport> getSports() {
        return sportsService.getSports();
    }

    @GetMapping("/findSport/{sportName}")
    public ResponseEntity<?> findSportByName(@PathVariable String sportName) {
        Optional<Sport> sport = sportsService.getSports().stream().filter(s -> s.getName().equals(sportName)).findFirst();

        if (sport.isPresent()) {
            return ResponseEntity.ok(sport.get().getLevel());
        } else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Deporte no encontrado");
        }
    }

    @GetMapping("/findSportsPersons")
    @ResponseBody
    public List<PersonDTO> findPersons() {
        List<PersonDTO> personDTOS = new ArrayList<>();

        for (Person person : personsService.getPersons()) {
            PersonDTO personDTO = new PersonDTO(person.getName(), person.getSurname(), person.getSport().getName());
            personDTOS.add(personDTO);
        }

        return personDTOS;
    }
}
