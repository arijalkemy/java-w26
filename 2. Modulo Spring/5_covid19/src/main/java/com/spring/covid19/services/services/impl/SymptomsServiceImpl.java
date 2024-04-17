package com.spring.covid19.services.services.impl;

import com.spring.covid19.models.Symptom;
import com.spring.covid19.repository.SymptomsRepository;
import com.spring.covid19.services.IPersonsService;
import com.spring.covid19.services.ISymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomsServiceImpl implements ISymptomsService {

    private final SymptomsRepository symptomsRepository;

    @Autowired
    IPersonsService personsService;

    public SymptomsServiceImpl(){
        this.symptomsRepository = new SymptomsRepository();
    }

    @Override
    public List<Symptom> getAllSymptoms() {
        return symptomsRepository.getSymptoms();
    }

    @Override
    public Integer getRiskLevelBySymptomName(String name) {
        return symptomsRepository.getSymptoms().stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .map(Symptom::getRisklevel)
                .orElse(null);
    }

}
