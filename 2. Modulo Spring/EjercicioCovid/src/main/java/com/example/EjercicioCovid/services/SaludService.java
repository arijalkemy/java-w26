package com.example.EjercicioCovid.services;

import com.example.EjercicioCovid.dto.PersonaDTO;
import com.example.EjercicioCovid.dto.SintomaDTO;

import java.util.List;

public interface SaludService {
    List<SintomaDTO> findAllSymptoms();
    String findSymptomByName(String name);
    List<PersonaDTO> findHighRiskPersons();
}
