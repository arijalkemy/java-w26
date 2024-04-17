package com.mercadolibre.covid19.service.imp;

import com.mercadolibre.covid19.model.entity.Symptom;
import com.mercadolibre.covid19.repository.MockRepository;
import com.mercadolibre.covid19.service.ISymptomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomServiceImp implements ISymptomService {
    @Override
    public List<Symptom> findAll() {
        return MockRepository.symptoms;
    }

    @Override
    public String findSeverityByName(String name) {
        return MockRepository.symptoms.stream()
                .filter(symptom -> symptom.getName().equals(name))
                .map(Symptom::getSeverity)
                .findFirst()
                .orElse(null);
    }
}
