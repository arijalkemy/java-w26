package com.example.dto_y_response_entityp2.repository;

import com.example.dto_y_response_entityp2.entity.Symptom;

import java.util.List;
import java.util.Optional;

public interface ISymptomsRepository {
    List<Symptom> getAll();

    Optional<Symptom> getSymptom(String name);
}
