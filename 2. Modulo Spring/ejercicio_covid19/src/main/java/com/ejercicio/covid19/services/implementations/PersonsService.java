package com.ejercicio.covid19.services.implementations;

import com.ejercicio.covid19.DTOs.RiskPersonResponseDTO;
import com.ejercicio.covid19.models.Symptom;
import com.ejercicio.covid19.repositories.implementations.PersonsRepository;
import com.ejercicio.covid19.repositories.implementations.SymptomsRepository;
import com.ejercicio.covid19.services.interfaces.IPersonsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonsService implements IPersonsService {
    private PersonsRepository personsRepository = new PersonsRepository();
    private SymptomsRepository symptomsRepository = new SymptomsRepository();

    @Override
    public List<RiskPersonResponseDTO> getRiskPersons() {
        setPersonsSymptoms();

        return personsRepository.getAll()
                .stream()
                .filter(person -> person.getAge() >= 60)
                .map(person -> new RiskPersonResponseDTO(
                        person.getName(),
                        person.getLastName(),
                        person.getSymptom().getName())
                )
                .collect(Collectors.toList());
    }

    private void setPersonsSymptoms() {
        for(int i=0; i < personsRepository.getAll().size(); i++) {
            Symptom symptom = symptomsRepository.getAll().get(i);
            personsRepository.getAll().get(i).setSymptom(symptom);
        }
    }
}
