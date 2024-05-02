package org.bootcamp.athletes.repository;

import org.bootcamp.athletes.model.Person;
import org.bootcamp.athletes.model.Sport;

import java.util.List;

public interface IAthletesRepository {
    List<Sport> getSports();

    Sport getSportByName(String name);

    List<Person> getPersons();
}
