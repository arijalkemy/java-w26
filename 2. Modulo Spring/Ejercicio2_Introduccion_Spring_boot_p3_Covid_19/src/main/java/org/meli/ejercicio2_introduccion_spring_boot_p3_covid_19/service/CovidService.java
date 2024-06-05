package org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.dto.PersonDTO;
import org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.dto.SymptomDTO;
import org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.dto.SymptomPersonDTO;
import org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.repository.CovidRepository;
import org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.repository.ICovidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CovidService implements ICovidService {
    @Autowired
    private ICovidRepository covidRepository;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public Set<SymptomDTO> getAllSymptoms() {
        return covidRepository.selectAllSymptoms()
                .stream()
                .map(symptoms-> mapper.convertValue(symptoms, SymptomDTO.class))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<SymptomDTO> getSymptomById(String symptoms) {
        return covidRepository.filterBySymptoms(symptoms)
                .stream()
                .map(s -> mapper.convertValue(s, SymptomDTO.class))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<SymptomPersonDTO> listSymptomsAssociatedPeople() {
        return covidRepository.selectCriticalPeople()
                .stream()
                .map(s -> {
                            SymptomPersonDTO symptomPersonDTO = mapper.convertValue(s, SymptomPersonDTO.class);
                            symptomPersonDTO.setPersonsCritical(new HashSet<>());
                            s.getPersonsCritical().forEach(
                                   symptomPersonDTOPerson ->
                                   {symptomPersonDTO.getPersonsCritical()
                                    .add(mapper.convertValue(symptomPersonDTOPerson, PersonDTO.class));
                                   }
                            );
                            return symptomPersonDTO;
                        })
                .collect(Collectors.toSet());
    }
}
