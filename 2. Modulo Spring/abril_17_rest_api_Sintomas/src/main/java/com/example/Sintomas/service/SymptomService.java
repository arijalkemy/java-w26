package com.example.Sintomas.service;

import com.example.Sintomas.entity.Symptom;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SymptomService implements ISymptom {

    private static List<Symptom> symptoms;

    public SymptomService() {
        symptoms = new ArrayList<>();
        symptoms.add(new Symptom(1, "Fiebre", "Alta"));
        symptoms.add(new Symptom(2, "Tos", "Baja"));
        symptoms.add(new Symptom(3, "Dolor de garganta", "Alto"));
        symptoms.add(new Symptom(4, "Dificultad para respirar", "Baja"));
        symptoms.add(new Symptom(5, "Dolor de cabeza", "Alto"));
        symptoms.add(new Symptom(6, "Dolor de cuerpo", "Bajo"));
    }
    public List<Symptom> getAll() {
        return symptoms;
    }

    public Symptom getByName(String name) {
        for (Symptom symptom : symptoms) {
            if (symptom.getName().equals(name)) {
                return symptom;
            }
        }
        return null;
    }
}
