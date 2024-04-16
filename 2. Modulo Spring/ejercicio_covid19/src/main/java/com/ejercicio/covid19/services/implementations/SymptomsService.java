package com.ejercicio.covid19.services.implementations;

import com.ejercicio.covid19.models.Symptom;
import com.ejercicio.covid19.repositories.implementations.SymptomsRepository;
import com.ejercicio.covid19.services.interfaces.ISymptomsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomsService implements ISymptomsService {
    private SymptomsRepository symptomsRepository = new SymptomsRepository();

    @Override
    public List<Symptom> getAllSymptoms() {
        return symptomsRepository.getAll();
    }

    @Override
    public Symptom getSymptomByName(String name) {
        return symptomsRepository.getByName(name);
    }
}
