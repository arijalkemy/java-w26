package com.example.Sports.service;

import com.example.Sports.dto.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class PersonService implements IPerson {

    private static List <PersonDTO> people;

    PersonService() {
        people = new ArrayList<>();
        people.add(new PersonDTO("John", "Doe", "Football"));
        people.add(new PersonDTO("Jane", "Doe", "Basketball"));
        people.add(new PersonDTO("Alice", "Doe", "Tennis"));
        people.add(new PersonDTO("Bob", "Doe", "Golf"));
    }


    @Override
    public List<PersonDTO> getPeople() {
        return people;
    }
}
