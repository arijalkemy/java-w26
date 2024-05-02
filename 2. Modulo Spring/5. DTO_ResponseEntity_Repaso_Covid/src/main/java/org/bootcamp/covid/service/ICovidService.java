package org.bootcamp.covid.service;

import org.bootcamp.covid.dto.PersonDTO;
import org.bootcamp.covid.dto.SymptomDTO;

import java.util.List;

public interface ICovidService {
    List<SymptomDTO> findSymptoms();

    SymptomDTO findSymptomByName(String name);

    List<PersonDTO> findRiskPerson();
}
