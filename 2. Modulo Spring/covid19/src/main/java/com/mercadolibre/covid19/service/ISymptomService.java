package com.mercadolibre.covid19.service;

import com.mercadolibre.covid19.model.entity.Symptom;

import java.util.List;

public interface ISymptomService {
    List<Symptom> findAll();
    String findSeverityByName(String name);

}
