package com.spring.covid19.services;


import com.spring.covid19.models.Person;
import com.spring.covid19.models.dto.RiskPersonDTO;

import java.util.List;

public interface IPersonsService {

    List<Person> getAllPersons();

    List<RiskPersonDTO> getAllRiskPersons(Integer maxAge);

}
