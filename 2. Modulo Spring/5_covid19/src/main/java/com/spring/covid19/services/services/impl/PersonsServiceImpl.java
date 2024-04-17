package com.spring.covid19.services.services.impl;

import com.spring.covid19.models.Person;
import com.spring.covid19.models.dto.RiskPersonDTO;
import com.spring.covid19.repository.PersonsRepository;
import com.spring.covid19.repository.SymptomsRepository;
import com.spring.covid19.services.IPersonsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonsServiceImpl implements IPersonsService {

    private final PersonsRepository personsRepository;
    private final SymptomsRepository symptomsRepository;

    public PersonsServiceImpl(){
        this.personsRepository = new PersonsRepository();
        this.symptomsRepository = new SymptomsRepository();
    }

    @Override
    public List<Person> getAllPersons() {
        return this.personsRepository.getPersons();
    }

    @Override
    public List<RiskPersonDTO> getAllRiskPersons(Integer maxAge) {
        List<RiskPersonDTO> dtoList = new ArrayList<>();
        for(Person person : this.getAllPersons().stream().filter(p -> p.getAge() <= maxAge).toList()){
            RiskPersonDTO riskPersonDTO = new RiskPersonDTO(
                    person.getName() + " " + person.getSurname(),
                    this.symptomsRepository.getPersonsSymptoms().get(person.getId()));
            dtoList.add(riskPersonDTO);
        }
        return dtoList;
    }
}
