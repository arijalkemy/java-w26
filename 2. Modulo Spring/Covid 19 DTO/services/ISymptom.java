package org.example.api.services;

import org.example.api.entities.Symptom;

import java.util.List;

public interface ISymptom {
    List<Symptom> findAllSymptom();

    Symptom findSymptomByname(String name);
}
