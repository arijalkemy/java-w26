package com.spring.covid19.repositories;

import com.spring.covid19.entities.Person;
import com.spring.covid19.entities.Symptom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {
    List<Person> persons = List.of(new Person(1, "Maca", "Caridad", 29,
            List.of(SymptomRepository.symptoms.get(1))), new Person(2, "Maca", "Caridad", 29,
            List.of(SymptomRepository.symptoms.get(2))), new Person(3, "Maca", "Caridad", 69,
            List.of(SymptomRepository.symptoms.get(3))));

    public List<Person> findAll() {
        return persons;
    }
    public List<Person> findRiskPerson() {
        return persons.stream().filter(x -> x.getAge()>60).filter(x -> x.getSymptoms().size()>0).toList();
    }
}
