package org.example.integradordeportistas.repository;

import org.example.integradordeportistas.model.Person;
import org.example.integradordeportistas.model.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SportsPersonRepository {

    private final List<Person> person;
    private final List<Sport> sports;

    public SportsPersonRepository(){
        person = new ArrayList<>();
        sports = new ArrayList<>();

        // Deportes
        Sport sport1 = new Sport("Swimming", "Pro");
        sports.add(sport1);

        Sport sport2 = new Sport("Soccer", "Amateur");
        sports.add(sport2);

        Sport sport3 = new Sport("Baseball", "Intermediate");
        sports.add(sport3);

        Sport sport4 = new Sport("Basketball", "Pro");
        sports.add(sport4);

        Sport sport5 = new Sport("Archery", "Pro");
        sports.add(sport5);

        Sport sport6 = new Sport("Bowling", "Amateur");
        sports.add(sport6);

        Sport sport7 = new Sport("Skating", "Intermediate");
        sports.add(sport7);

        // Personas
        Person person1 = new Person("Pepe", "Rodríguez", 23, sport1);
        person.add(person1);

        Person person2 = new Person("Andres", "Lugo", 16, sport2);
        person.add(person2);

        Person person3 = new Person("Felipe", "Gonzáles", 32, sport1);
        person.add(person3);

        Person person4 = new Person("Salomé", "Uribe", 41);
        person.add(person4);

        Person person5 = new Person("Maria", "Galindo", 28, sport3);
        person.add(person5);

        Person person6 = new Person("Laura", "Torres", 20);
        person.add(person6);

        Person person7 = new Person("Monica", "Caseca", 21, sport6);
        person.add(person7);

        Person person8 = new Person("Samuel", "Galindo", 19, sport7);
        person.add(person8);

    }

    public List<Person> getPerson() {
        return person;
    }

    public List<Sport> getSports() {
        return sports;
    }
}
