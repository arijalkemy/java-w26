package org.example.dto_p2_covid.person;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class PersonRepository {
    public List<Person> getAllPerson() {
        return Arrays.asList(
                new Person(1, "juan", "jimenez", 72),
                new Person(2, "Carlos", "moreno", 18),
                new Person(2, "Camilo", "Sanchez", 20),
                new Person(2, "Dolores", "Mart", 80),
                new Person(2, "Sofia", "Char", 24),
                new Person(2, "Alejandra", "Martinez", 30)
        );
    }
}
