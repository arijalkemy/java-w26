package com.example.Sintomas.service;


import com.example.Sintomas.entity.Symptom;

import java.util.List;
public interface ISymptom {
    public List<Symptom> getAll();
    public Symptom getByName(String name);
}
