package com.ejercicio.covid19.repositories.implementations;

import com.ejercicio.covid19.models.Symptom;
import com.ejercicio.covid19.repositories.interfaces.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SymptomsRepository implements IRepository<Symptom> {
    private List<Symptom> symptoms = createSymptoms();

    @Override
    public List<Symptom> getAll() {
        return symptoms;
    }

    @Override
    public Symptom getByName(String name) {
        Optional<Symptom> result = symptoms
                .stream()
                .filter(symptom -> symptom.getName().equals(name))
                .findFirst();

        if (result.isPresent()) return result.get();
        return null;
    }

    private List<Symptom> createSymptoms() {
        List<Symptom> symptoms = new ArrayList<Symptom>();

        symptoms.add(new Symptom("ABC123", "Fiebre", "Medio"));
        symptoms.add(new Symptom("AKD356", "Pérdida del olfato o el gusto", "Bajo"));
        symptoms.add(new Symptom("GES493", "Náuseas o vómitos", "Medio"));
        symptoms.add(new Symptom("FGE382", "Dificultad para respirar", "Alto"));
        symptoms.add(new Symptom("KSO532", "Tos", "Bajo"));

        return symptoms;
    }
}
