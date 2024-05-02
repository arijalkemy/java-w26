package org.bootcamp.covid.service;

import org.bootcamp.covid.dto.PersonDTO;
import org.bootcamp.covid.dto.SymptomDTO;
import org.bootcamp.covid.model.Symptom;
import org.bootcamp.covid.repository.ICovidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidServiceImpl implements ICovidService{
    @Autowired
    ICovidRepository covidRepository;

    @Override
    public List<SymptomDTO> findSymptoms() {
        return covidRepository.getSymptoms().stream().map(symptom -> new SymptomDTO(symptom.getCode(),
                symptom.getName(),
                symptom.getSeverityLevel())).toList();
    }

    @Override
    public SymptomDTO findSymptomByName(String name) {
        Symptom symptom = covidRepository.findSymptomByName(name);
        return new SymptomDTO(symptom.getCode(), symptom.getName(), symptom.getSeverityLevel());
    }

    @Override
    public List<PersonDTO> findRiskPerson() {
        return covidRepository.getRiskPersons().stream().map(person -> new PersonDTO(person.getName(),
                person.getLastName(),
                person.getSymptoms().stream().map(symptom -> new SymptomDTO(symptom.getCode(),
                        symptom.getName(),
                        symptom.getSeverityLevel())).toList())).toList();
    }
}
