package com.bootcamp.covid19.service;

import com.bootcamp.covid19.dto.RiskPersonDTO;
import com.bootcamp.covid19.entity.Sintoma;

import java.util.List;

public interface ICovidService {
    List<Sintoma> findAllSymptoms();
    Sintoma findSymptomByName(String name);

    List<RiskPersonDTO> findRiskPerson();
}
