package org.example.dto_p2_covid.symptoms;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class SymptomRepository {
    public List<Symptom> getAllSymptom() {
        return Arrays.asList(
                new Symptom(1, "Fiebre", "B"),
                new Symptom(2, "Tos", "C"),
                new Symptom(3, "Dificultad para respirar", "S"),
                new Symptom(4, "Fatiga", "A"),
                new Symptom(5, "Dolor muscular", "B"),
                new Symptom(6, "Dolor de cabeza", "A")
        );
    }
}
