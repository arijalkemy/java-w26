package com.Ejercicio.Deportistas.Repository;

import com.Ejercicio.Deportistas.Entity.Person;
import com.Ejercicio.Deportistas.Entity.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements IPersonRepository {

    private static List<Person> persons = new ArrayList<>();

    public PersonRepositoryImpl() {
        persons.add(new Person("Juan", "García", 30, new Sport("Fútbol", "Profesional")));
        persons.add(new Person("María", "Martínez", 25, new Sport("Baloncesto", "Amateur")));
        persons.add(new Person("Pedro", "López", 35, new Sport("Tenis", "Profesional")));
        persons.add(new Person("Ana", "Sánchez", 28, new Sport("Natación", "Recreativo")));
        persons.add(new Person("Luis", "Rodríguez", 32, new Sport("Atletismo", "Profesional")));
    }

    @Override
    public List<Person> findAllPerson() {
        return persons;
    }
}
