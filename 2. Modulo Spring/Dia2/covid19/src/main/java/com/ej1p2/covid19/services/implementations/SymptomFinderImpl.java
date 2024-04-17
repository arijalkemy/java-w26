package com.ej1p2.covid19.services.implementations;

import com.ej1p2.covid19.model.Symptom;
import com.ej1p2.covid19.services.ISymptomFinder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SymptomFinderImpl implements ISymptomFinder {
    List<Symptom> symptoms = new ArrayList<>();

    @Override
    public List<Symptom> findAllSymptoms() {
        Symptom symptom1 = new Symptom(123, "symptom1", "Mild");
        Symptom symptom2 = new Symptom(456, "symptom2", "Moderate");
        Symptom symptom3 = new Symptom(789, "symptom3", "Critical");

        symptoms.add(symptom1);
        symptoms.add(symptom2);
        symptoms.add(symptom3);

        return symptoms;
    }

    @Override
    public String findSeverityBySymptom(String symptomName) {
        Symptom symptom1 = new Symptom(123, "symptom1", "Mild");
        Symptom symptom2 = new Symptom(456, "symptom2", "Moderate");
        Symptom symptom3 = new Symptom(789, "symptom3", "Critical");

        symptoms.add(symptom1);
        symptoms.add(symptom2);
        symptoms.add(symptom3);

        for (Symptom symptom : symptoms) {
            if (symptom.getName().equals(symptomName)) {
                return symptom.getSeverityLevel();
            }
        }
        return null;
    }
}
