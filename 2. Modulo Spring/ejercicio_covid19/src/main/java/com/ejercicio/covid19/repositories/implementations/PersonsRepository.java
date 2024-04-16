package com.ejercicio.covid19.repositories.implementations;

import com.ejercicio.covid19.models.Person;
import com.ejercicio.covid19.models.Symptom;
import com.ejercicio.covid19.repositories.interfaces.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonsRepository implements IRepository<Person> {
    private List<Person> personList = createPersons();
    @Override
    public List<Person> getAll() {
        return personList;
    }

    @Override
    public Person getByName(String name) {
        Optional<Person> result = personList
                .stream()
                .filter(person -> person.getName().equals(name))
                .findFirst();

        if (result.isPresent()) return result.get();
        return null;
    }

    private List<Person> createPersons() {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person(0,"Carlos", "Tevez", 65));
        persons.add(new Person(1,"Lionel", "Messi", 23));
        persons.add(new Person(2,"Juan", "Jo-C", 78));
        persons.add(new Person(3,"Nicolas", "Hernandez", 65));
        persons.add(new Person(4,"Cristian", "Romero", 26));

        return persons;
    }
}
