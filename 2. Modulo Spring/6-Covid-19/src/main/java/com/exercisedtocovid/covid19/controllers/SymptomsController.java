package com.exercisedtocovid.covid19.controllers;


import com.exercisedtocovid.covid19.classes.Person;
import com.exercisedtocovid.covid19.classes.Symptom;
import com.exercisedtocovid.covid19.dtos.PersonDTO;
import com.exercisedtocovid.covid19.services.IPersonsService;
import com.exercisedtocovid.covid19.services.ISymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SymptomsController {
    @Autowired
    ISymptomsService symptomsService;
    @Autowired
    IPersonsService personsService;

    @GetMapping("/findSymptoms")
    public List<Symptom> findSymptoms() {
        return symptomsService.getSymptoms();
    }

    @GetMapping("/findSymptoms/{symptomName}")
    public ResponseEntity<?> findSportByName(@PathVariable String symptomName) {
        Optional<Symptom> sport = symptomsService.getSymptoms().stream().filter(s -> s.getName().equals(symptomName)).findFirst();

        if (sport.isPresent()) {
            return ResponseEntity.ok("Nivel de gravedad es " + sport.get().getSeverityLevel());
        } else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Symptom not found");
        }
    }

    @GetMapping("/findRiskPersons")
    @ResponseBody
    public List<PersonDTO> findPersons() {
        List<PersonDTO> personDTOS = new ArrayList<>();

        for (Person person : personsService.getPersons()) {
            if (person.getSymptoms().size() >= 1 && person.getAge() >= 60) {
                PersonDTO personDTO = new PersonDTO(person.getName(), person.getSurname(), person.getAge(), person.getSymptoms());
                personDTOS.add(personDTO);
            }
        }

        return personDTOS;
    }
}
