package com.spring.covid19.repositories;

import com.spring.covid19.entities.Symptom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SymptomRepository {
    static List<Symptom> symptoms = List.of(new Symptom(1, "Fiebre", 2),
            new Symptom(2, "Dolor de cabeza", 1),
            new Symptom(3, "Dolor corporal", 3),
            new Symptom(4, "Moco", 3));

    public List<Symptom> findAll() {
        return symptoms;
    }
    public Symptom findByName(String name) {
        return symptoms.stream().filter(x -> x.getName().equals(name)).findFirst().get();
    }
}
