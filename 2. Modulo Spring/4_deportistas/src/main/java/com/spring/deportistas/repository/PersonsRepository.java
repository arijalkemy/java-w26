package com.spring.deportistas.repository;

import com.spring.deportistas.models.Person;
import com.spring.deportistas.models.Sport;

import java.util.List;
import java.util.Map;

public class PersonsRepository {

    public static final Map<String, Person> personsMap = Map.of(
            "matias_pinto", new Person("Matias", "Pinto", 26),
            "nicolas_rodriguez", new Person("Nicolas", "Rodriguez", 22)
    );

    private List<Person> persons;

    public PersonsRepository() {
        this.persons = List.of(
                new Person("Matias", "Pinto", 26),
                new Person("Nicolas", "Rodriguez", 22)
        );
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
