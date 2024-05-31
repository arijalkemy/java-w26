package com.example.dto_y_response_entityp2.repository;

import com.example.dto_y_response_entityp2.entity.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SymptomsRepository implements ISymptomsRepository{
    private List<Symptom> symptomList;

    public SymptomsRepository() {
        this.symptomList = new ArrayList<>();
        symptomList.add(new Symptom(1L,"Tos",1L));
        symptomList.add(new Symptom(2L,"Escurrimiento nasal",1L));
        symptomList.add(new Symptom(3L,"Fiebre",3L));
        symptomList.add(new Symptom(4L,"Sianosis",5L));
        symptomList.add(new Symptom(5L,"Fibrosis pulmonar",5L));
        symptomList.add(new Symptom(6L,"Amputacion",5L));
        symptomList.add(new Symptom(7L,"Sangrado",5L));
    }


    @Override
    public List<Symptom> getAll() {
        return symptomList;
    }

    @Override
    public Optional<Symptom> getSymptom(String name) {
        return symptomList.stream()
                .filter(symptom -> symptom.getName().toUpperCase().equals(name.toUpperCase()))
                .findFirst();
    }
}
