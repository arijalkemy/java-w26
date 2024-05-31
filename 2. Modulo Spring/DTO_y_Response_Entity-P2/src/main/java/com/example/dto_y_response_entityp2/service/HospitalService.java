package com.example.dto_y_response_entityp2.service;

import com.example.dto_y_response_entityp2.dto.PersonDTO;
import com.example.dto_y_response_entityp2.dto.SymptomsDto;
import com.example.dto_y_response_entityp2.entity.Person;
import com.example.dto_y_response_entityp2.entity.Symptom;
import com.example.dto_y_response_entityp2.entity.SymptomPerson;
import com.example.dto_y_response_entityp2.exception.NotFoundException;
import com.example.dto_y_response_entityp2.repository.IPersonRepository;
import com.example.dto_y_response_entityp2.repository.ISymptomsRepository;
import com.example.dto_y_response_entityp2.repository.SympotmsPersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HospitalService implements IHospitalService{

    final ModelMapper mm = new ModelMapper();

    @Autowired
    ISymptomsRepository symptomsRepository;
    @Autowired
    IPersonRepository personRepository;
    @Autowired
    SympotmsPersonRepository relation;
    @Override
    public List<SymptomsDto> getAllSymptoms() {
        List<Symptom> symptomList = symptomsRepository.getAll();

        return symptomList.stream()
                .map(symptom -> mm.map(symptom, SymptomsDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SymptomsDto getSymptom(String name) {
        Optional<Symptom> isSymptom = symptomsRepository.getSymptom(name);
        if(isSymptom.isEmpty()){
            throw new NotFoundException("Sintoma no registrado");
        }
        return mm.map(isSymptom.get(), SymptomsDto.class);
    }

    @Override
    public List<PersonDTO> getRiskPersons() {
        //Obtenemos la lista de personas
        List<Person> riskList = personRepository.getAll();

        //Obtenemos los id de las personas en riesgo (mayores de 60 años)
        List<Long> ids = riskList.stream()
                .filter(person -> person.getAge() >= 60)
                .map(Person::getId)
                .toList();

        //Obtenemos todas las relaciones entre síntomas y personas
        List<SymptomPerson> relationList = relation.getAll();

        //Filtramos las relaciones para obtener solo aquellas cuyo ID de persona está en la lista de IDs de personas en riesgo
        List<SymptomPerson> filteredSymptomPersonList = relationList.stream()
                .filter(symptomPerson -> ids.contains(symptomPerson.getIdPerson()))
                .collect(Collectors.toList());

        //Obtenemos los IDs de las personas en riesgo filtradas
        Set<Long> filteredPersonIds = filteredSymptomPersonList.stream()
                .map(SymptomPerson::getIdPerson)
                .collect(Collectors.toSet());

        //Filtramos la lista de personas en riesgo original usando los IDs filtrados
        List<Person> riskPersons = riskList.stream()
                .filter(person -> filteredPersonIds.contains(person.getId()))
                .collect(Collectors.toList());

        //Convertimos las personas en riesgo a DTOs
        List<PersonDTO> riskPersonDTOs = riskPersons.stream()
                .map(person -> mm.map(person, PersonDTO.class))
                .collect(Collectors.toList());

        return riskPersonDTOs;
    }
}
