package meli.bootcamp.covid19.repositories;

import meli.bootcamp.covid19.entities.Person;
import meli.bootcamp.covid19.entities.Symptom;

import java.util.List;

public class PersonRepository {
    public static List<Person> persons = List.of(
            new Person(1, "Juan", "Perez", 72, List.of(
                    SymptomRepository.symptoms.get(0),
                    SymptomRepository.symptoms.get(1),
                    SymptomRepository.symptoms.get(3)
            )),
            new Person(2, "Maria", "Juarez", 60, List.of(
                    SymptomRepository.symptoms.get(0),
                    SymptomRepository.symptoms.get(4),
                    SymptomRepository.symptoms.get(5)
            )),
            new Person(3, "Pedro", "Capo", 21, List.of(
                    SymptomRepository.symptoms.get(1),
                    SymptomRepository.symptoms.get(2),
                    SymptomRepository.symptoms.get(5)
            ))
    );
}
