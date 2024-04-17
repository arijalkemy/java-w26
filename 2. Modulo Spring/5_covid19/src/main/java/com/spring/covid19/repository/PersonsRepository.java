package com.spring.covid19.repository;

import com.spring.covid19.models.Person;

import java.util.List;

public class PersonsRepository {

    private List<Person> persons;

    public PersonsRepository() {
        persons = List.of(
            new Person("40000000", "Matias", "Pinto", 26),
            new Person("39999999", "Nicolas", "Jujex", 65),
            new Person("14444444", "Daniel", "Lolo", 60)
        );
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
