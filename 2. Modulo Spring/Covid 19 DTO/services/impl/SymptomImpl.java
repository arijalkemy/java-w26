package org.example.api.services.impl;

import org.example.api.entities.Symptom;
import org.example.api.services.ISymptom;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class SymptomImpl implements ISymptom {
    private final List<Symptom> symptomList;

    public SymptomImpl(@Qualifier("symptomList") List<Symptom> symptomList) {
        this.symptomList = symptomList;
    }

    @Override
    public Symptom findSymptomByname(String name) {
        return this.symptomList.stream()
                .filter(symptom -> symptom.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Symptom> findAllSymptom() {
        return this.symptomList;
    }
}
