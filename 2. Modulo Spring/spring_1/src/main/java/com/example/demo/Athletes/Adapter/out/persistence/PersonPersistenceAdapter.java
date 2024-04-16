package com.example.demo.Athletes.Adapter.out.persistence;

import com.example.demo.Athletes.Application.out.response.IPersonFinds;
import com.example.demo.Athletes.Domain.Person;
import com.example.demo.Athletes.Domain.Sport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonPersistenceAdapter implements IPersonFinds {

    private static final List<Person> personsList = new ArrayList<>();

    static {
        getRandomPersons();
    }

    private static void getRandomPersons() {
        personsList.add(new Person("John", "Smith", 30, Arrays.asList(
                new Sport("Soccer", 5),
                new Sport("Basketball", 4)
        )));

        personsList.add(new Person("Emma", "Johnson", 25, Arrays.asList(
                new Sport("Tennis", 3),
                new Sport("Swimming", 2),
                new Sport("Cycling", 1)
        )));

        personsList.add(new Person("Michael", "Williams", 40, Arrays.asList(
                new Sport("Soccer", 4),
                new Sport("Basketball", 3)
        )));

        personsList.add(new Person("Sophia", "Brown", 35, Arrays.asList(
                new Sport("Tennis", 5),
                new Sport("Swimming", 4)
        )));

        personsList.add(new Person("William", "Jones", 28, List.of(
                new Sport("Soccer", 3)
        )));

        personsList.add(new Person("Olivia", "Miller", 32, Arrays.asList(
                new Sport("Basketball", 5),
                new Sport("Tennis", 4),
                new Sport("Cycling", 2)
        )));

        personsList.add(new Person("James", "Davis", 45, Arrays.asList(
                new Sport("Soccer", 2),
                new Sport("Basketball", 1)
        )));

        personsList.add(new Person("Ava", "Garcia", 22, Arrays.asList(
                new Sport("Tennis", 2),
                new Sport("Swimming", 1)
        )));

        personsList.add(new Person("Alexander", "Rodriguez", 38, Arrays.asList(
                new Sport("Soccer", 1),
                new Sport("Basketball", 2),
                new Sport("Tennis", 3)
        )));

        personsList.add(new Person("Isabella", "Martinez", 27, List.of(
                new Sport("Swimming", 3)
        )));
    }

    @Override
    public List<Person> findAll() {
        return personsList;
    }

    @Override
    public List<Person> findByName(String name) {
        return personsList.stream().filter(p -> p.getName().equalsIgnoreCase(name)).toList();
    }

    @Override
    public List<Person> findBySport(String sportName) {
        return personsList.stream()
                .filter(person -> person.getSports().stream().anyMatch(s -> s.getName().equals(sportName)))
                .collect(Collectors.toList());
    }
}
