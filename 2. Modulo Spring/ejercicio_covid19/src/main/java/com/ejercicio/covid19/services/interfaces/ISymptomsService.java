package com.ejercicio.covid19.services.interfaces;

import com.ejercicio.covid19.models.Symptom;

import java.util.List;

public interface ISymptomsService {
    public List<Symptom> getAllSymptoms();
    public Symptom getSymptomByName(String name);
}
