package com.spring.covid19.services.services.impl;

import com.spring.covid19.models.Person;
import com.spring.covid19.repository.PersonsRepository;
import com.spring.covid19.services.IPersonsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonsServiceImpl implements IPersonsService {

    private final PersonsRepository personsRepository;

    public PersonsServiceImpl(){
        this.personsRepository = new PersonsRepository();
    }

    @Override
    public List<Person> getAllPersons() {
        return this.personsRepository.getPersons();
    }
}
