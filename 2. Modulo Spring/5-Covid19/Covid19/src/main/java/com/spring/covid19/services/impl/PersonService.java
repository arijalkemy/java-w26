package com.spring.covid19.services.impl;

import com.spring.covid19.dtos.RiskPersonDTO;
import com.spring.covid19.repositories.PersonRepository;
import com.spring.covid19.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<RiskPersonDTO> findRiskPersons() {
        return personRepository.findRiskPerson().stream().map(x -> new RiskPersonDTO(x.getName(), x.getLastname())).toList();
    }

}
