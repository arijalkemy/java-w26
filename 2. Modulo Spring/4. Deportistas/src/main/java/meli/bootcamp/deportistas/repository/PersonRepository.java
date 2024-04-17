package meli.bootcamp.deportistas.repository;

import meli.bootcamp.deportistas.entities.Person;
import meli.bootcamp.deportistas.entities.Sport;

import java.util.List;

public class PersonRepository {
    public static final List<Person> PERSONS = List.of(
            new Person("Juan", "Perez", 20, new Sport("Tenis", "2")),
            new Person("Maria", "Lopez", 20, null),
            new Person("Lucia", "Gimenez", 20, new Sport("Rugby", "4"))
    );
}
