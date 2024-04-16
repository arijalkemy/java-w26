package com.example.demo.Athletes.Adapter.out.persistence;

import com.example.demo.Athletes.Application.out.IPersonFinds;
import com.example.demo.Athletes.Domain.Person;
import com.example.demo.Athletes.Domain.Sport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonPersistenceAdapter implements IPersonFinds {

    private final List<Person> personsList = getRandomPersons();

    private List<Person> getRandomPersons() {
        String[] names = {"John", "Emma", "Michael", "Sophia", "William", "Olivia", "James", "Ava", "Alexander", "Isabella"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Martinez"};
        List<Person> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            String name = names[random.nextInt(names.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            int age = random.nextInt(60) + 20; // Edad entre 20 y 80 años

            // Generar entre 1 y 3 deportes aleatorios
            List<Sport> sports = new ArrayList<>();
            int numSports = random.nextInt(3) + 1; // Entre 1 y 3 deportes
            for (int j = 0; j < numSports; j++) {
                Sport randomSport = getRandomSport();
                sports.add(randomSport);
            }

            // Crear la persona y agregarla a la lista
            Person person = new Person(name, lastName, age, sports);
            list.add(person);
        }
        return list;
    }

    private static Sport getRandomSport() {
        String[] sportNames = {"Soccer", "Basketball", "Tennis", "Swimming", "Cycling"};
        Random random = new Random();
        String name = sportNames[random.nextInt(sportNames.length)];
        int level = random.nextInt(5) + 1; // Nivel entre 1 y 5
        return new Sport(name, level);
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
