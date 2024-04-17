package meli.bootcamp.covid19.repositories;

import meli.bootcamp.covid19.entities.Symptom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SymptomRepository {
    public static List<Symptom> symptoms = List.of(
            new Symptom("fev", "Fever", "2"),
            new Symptom("cou", "Cough", "1"),
            new Symptom("difbre", "Difficulty Breathing", "5"),
            new Symptom("fat", "Fatigue", "3"),
            new Symptom("muac", "Muscle", "4"),
            new Symptom("hea", "Headache", "3")
    );
}
