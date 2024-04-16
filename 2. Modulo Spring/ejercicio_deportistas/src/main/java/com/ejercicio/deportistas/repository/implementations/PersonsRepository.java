package com.ejercicio.deportistas.repository.implementations;

import com.ejercicio.deportistas.entities.Person;
import com.ejercicio.deportistas.repository.interfaces.IRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonsRepository implements IRepository<Person> {
    private List<Person> persons = createPersons();

    @Override
    public List<Person> getAll() {
        return persons;
    }

    @Override
    public Person getByName(String name) {
        return null;
    }

    private List<Person> createPersons() {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Carlos", "Gomez", 23));
        persons.add(new Person("Juana", "De Arco", 36));
        persons.add(new Person("Jose", "Perez", 28));
        persons.add(new Person("Graciela", "Gonzalez", 24));
        persons.add(new Person("Hernan", "Martino", 30));

        return persons;
    }
}
