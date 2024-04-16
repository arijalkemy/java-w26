package com.spring.covid_19.Services;

import com.spring.covid_19.Dtos.RiskPersonDto;
import com.spring.covid_19.Models.Sintoma;

import java.util.List;
import java.util.Optional;

public interface ICovidService {
    List<Sintoma> findSymptoms();
    Optional<Sintoma> findSymptom(String nombre);
    List<RiskPersonDto> findRiskPersons();
}
