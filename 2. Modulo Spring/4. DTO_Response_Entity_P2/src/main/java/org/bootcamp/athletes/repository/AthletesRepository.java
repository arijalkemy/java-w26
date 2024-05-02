package org.bootcamp.athletes.repository;

import org.bootcamp.athletes.model.Person;
import org.bootcamp.athletes.model.Sport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AthletesRepository implements IAthletesRepository {
    private static final List<Sport> sports = List.of(
            new Sport("Football", "Easy"),
            new Sport("Basketball", "Medium"),
            new Sport("Tennis", "Hard"),
            new Sport("Swimming", "Easy"),
            new Sport("Running", "Medium"),
            new Sport("Cycling", "Hard")
    );
    private static final List<Person> persons = List.of(
            new Person("John", "Doe", 25, sports.get(0)),
            new Person("Jane", "Doe", 30, sports.get(1)),
            new Person("Alice", "Smith", 35, sports.get(2)),
            new Person("Bob", "Johnson", 40, sports.get(3)),
            new Person("Charlie", "Brown", 45, sports.get(4)),
            new Person("David", "Davis", 50, sports.get(5))
    );

    @Override
    public List<Sport> getSports() {
        return sports;
    }

    @Override
    public Sport getSportByName(String name) {
        return sports.stream()
                .filter(sport -> sport.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Person> getPersons() {
        return persons;
    }
}
