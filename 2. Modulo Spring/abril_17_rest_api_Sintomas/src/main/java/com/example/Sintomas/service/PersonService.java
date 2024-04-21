package com.example.Sintomas.service;

import com.example.Sintomas.dto.PersonAndSymptom;
import com.example.Sintomas.entity.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {


    private List<Person> people;

    PersonService(){
        people = new ArrayList<>();
        people.add(new Person(1, "Juan", "Perez", 20));
        people.add(new Person(2, "Maria", "Gomez", 30));
        people.add(new Person(3, "Pedro", "Gonzalez", 40));
        people.add(new Person(4, "Jose", "Rodriguez", 50));
        people.add(new Person(5, "Ana", "Lopez", 60));
        people.add(new Person(6, "Luis", "Martinez", 70));
        people.add(new Person(7, "Carlos", "Sanchez", 80));
        people.add(new Person(8, "Sofia", "Torres", 90));
    }

    public List<PersonAndSymptom> getPeopleGreatterThan60() {
        List<PersonAndSymptom> personAndSymptoms = new ArrayList<>();
        return people.stream().filter(person -> person.getAge() > 60).toList().stream()
                .map(person -> new PersonAndSymptom(person.getName(), person.getLastName(), "Fiebre")).collect(Collectors.toList());
    }
}
