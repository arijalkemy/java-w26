package org.example.ejercicio_covid.services.impl;

import org.example.ejercicio_covid.dto.RiskPersonDTO;
import org.example.ejercicio_covid.models.Person;
import org.example.ejercicio_covid.models.Symptom;
import org.example.ejercicio_covid.services.ICovidSevice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ICovidServiceImpl implements ICovidSevice {

    List<Symptom> symptomsList;
    List<Person> personList;

    public ICovidServiceImpl(List<Symptom> symptomsList, List<Person> personList) {
        this.symptomsList = Arrays.asList(
                new Symptom(1L,"Tos","Alto"),
                new Symptom(2L,"Fiebre","Alto"),
                new Symptom(3L,"Dificultad a respirar","Severo"),
                new Symptom(4L,"Fatiga","Medio"),
                new Symptom(5L,"Dolor de cabeza","Bajo"),
                new Symptom(6L,"Congestion","Alto"),
                new Symptom(7L,"Dolor de garganta","Medio")
                );
        this.personList = Arrays.asList(
                new Person(1L,"Jose","Pepe",40, Arrays.asList(
                        this.symptomsList.get(0),
                        this.symptomsList.get(1)
                        )),
                new Person(2L,"Manuel","Lopez",61, Arrays.asList(
                        this.symptomsList.get(0),
                        this.symptomsList.get(2),
                        this.symptomsList.get(3)
                )),
                new Person(3L,"Sofia","Sanchez",65, Arrays.asList(
                        this.symptomsList.get(0)
                )),
                new Person(4L,"Alex","Lopez",60, Arrays.asList(
                        this.symptomsList.get(5),
                        this.symptomsList.get(6),
                        this.symptomsList.get(4)
                )),
                new Person(5L,"Daniel","Melo",62)
        );
    }

    @Override
    public List<Symptom> findSymptom() {
        return this.symptomsList;
    }

    @Override
    public Symptom findSymptom(String name) {
        return this.symptomsList.stream().filter(x->x.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<RiskPersonDTO> findRiskPerson() {
        List<Person> riskPerson = this.personList.stream().filter(x-> x.getAge()>60 && !x.getSymptoms().isEmpty()).toList();
        return riskPerson.stream().map(x-> new RiskPersonDTO(x.getName(),x.getLastName(),x.getAge(),x.getSymptoms()) ).toList();
    }
}
