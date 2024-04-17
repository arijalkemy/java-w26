package com.spring.covid19.services;

import com.spring.covid19.models.Symptom;
import com.spring.covid19.models.dto.RiskPersonDTO;

import java.util.List;

public interface ISymptomsService {

    List<Symptom> getAllSymptoms();

    Integer getRiskLevelBySymptomName(String name);

}
