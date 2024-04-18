package com.Ejercicio.Covid.Repository;

import com.Ejercicio.Covid.Entity.Person;
import com.Ejercicio.Covid.Entity.Symptom;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    public static List<Symptom> symptomsList = List.of(
            new Symptom("SARS-CoV-2", "COVID-19", 7),
            new Symptom("DENV", "Dengue", 7),
            new Symptom("Rubeola", "Sarampion", 6));

    public static List<Person> personList = List.of(
            new Person(1, "Mauricio", "Dominguez", 64, symptomsList.get(0)),
            new Person(2, "Ricardo", "Darin", 20, symptomsList.get(1)),
            new Person(2, "Pepe", "Martinez", 76, symptomsList.get(2))
    );
}
