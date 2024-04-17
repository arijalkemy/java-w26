package com.spring.covid19.repository;

import com.spring.covid19.models.Symptom;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class SymptomsRepository {

    private final List<Symptom> symptoms;

    private final Map<String, List<String>> personsSymptoms;

    public SymptomsRepository() {
        this.symptoms = List.of(
                new Symptom("vomit", "Vomitos", 7),
                new Symptom("backpain", "Dolor de espalda", 5),
                new Symptom("fever", "Fiebre", 6),
                new Symptom("no-taste","Falta de gusto", 3)
        );

        this.personsSymptoms =  Map.of(
                "40000000", List.of("vomit","fever"),
                "39999999", List.of("no-taste"),
                "14444444", List.of("backpain", "no-taste", "vomit")
        );
    }

}
