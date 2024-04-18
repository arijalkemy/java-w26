package com.spring.covid19.services.impl;

import com.spring.covid19.dtos.SymptomDTO;
import com.spring.covid19.entities.Symptom;
import com.spring.covid19.repositories.SymptomRepository;
import com.spring.covid19.services.ISymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomServiceImpl implements ISymptomService {
    @Autowired
    SymptomRepository symptomRepository;

    @Override
    public List<SymptomDTO> getAll() {
        List<Symptom> symptoms = symptomRepository.findAll();
        return symptoms.stream().map(x -> new SymptomDTO(x.getName(), x.getSeverityLevel())).toList();
    }

    @Override
    public SymptomDTO getByName(String name) {
        Symptom symptom = symptomRepository.findByName(name);
        return new SymptomDTO(symptom.getName(), symptom.getSeverityLevel());
    }
}
