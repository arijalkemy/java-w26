package com.exercisedtocovid.covid19.services.implementations;

import com.exercisedtocovid.covid19.classes.Symptom;
import com.exercisedtocovid.covid19.repositories.Repository;
import com.exercisedtocovid.covid19.services.ISymptomsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomsServiceImpl implements ISymptomsService {
    @Override
    public List<Symptom> getSymptoms() {
        return Repository.symptoms;
    }
}
