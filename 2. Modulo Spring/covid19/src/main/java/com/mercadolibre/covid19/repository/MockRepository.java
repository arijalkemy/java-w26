package com.mercadolibre.covid19.repository;

import com.mercadolibre.covid19.model.entity.Person;
import com.mercadolibre.covid19.model.entity.Symptom;

import java.util.ArrayList;
import java.util.List;

public class MockRepository {
    public static List<Symptom> symptoms = new ArrayList<>(List.of(
            new Symptom(1, "Fever", "High"),
            new Symptom(2, "Congestion", "Low"),
            new Symptom(1, "Headache", "Medium")
    ));
    public static List<Person> people = new ArrayList<>(List.of(
            new Person(1,"Franco", "Moises", 21, List.of(symptoms.get(0), symptoms.get(2))),
            new Person(1,"Elian", "Moises", 62, List.of(symptoms.get(1)))

    ));
}
