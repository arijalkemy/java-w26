package org.example.covid.services.interfaces;

import org.example.covid.dto.PersonaEnRiesgoDTO;
import org.example.covid.entity.Sintoma;

import java.util.List;

public interface ICovidService {
    List<Sintoma> findSymptom();
    List<Sintoma> findSymptomByName(String symptomName);
    List<PersonaEnRiesgoDTO> findRiskPerson();
}
