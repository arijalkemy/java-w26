package com.ej1p2.covid19.services;

import com.ej1p2.covid19.model.Symptom;

import java.util.List;

public interface ISymptomFinder {
    List<Symptom> findAllSymptoms();
    String findSeverityBySymptom(String symptomName);
}
