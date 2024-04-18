package org.responseentity.exercice.symptom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomServiceImp implements SymptomService{
    @Autowired
    SymptomRepository symptomRepository;

    @Override
    public List<SymptomEntity> listSymptoms() {
        return this.symptomRepository.getAllSymptoms();
    }

    @Override
    public String getLevelOfSeverityByName(String name) {
        return this.symptomRepository.getLevelOfSeverityByName(name);
    }

    @Override
    public void insertSymptom(SymptomEntity symptomEntity) {
        this.symptomRepository.insertSymptom(symptomEntity);
    }
}
