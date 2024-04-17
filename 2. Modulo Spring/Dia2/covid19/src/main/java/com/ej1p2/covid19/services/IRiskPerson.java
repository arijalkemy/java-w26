package com.ej1p2.covid19.services;

import com.ej1p2.covid19.dto.PersonSymptomDTO;
import com.ej1p2.covid19.model.Person;

import java.util.List;

public interface IRiskPerson {
    List<PersonSymptomDTO> findRiskPersons();
}
