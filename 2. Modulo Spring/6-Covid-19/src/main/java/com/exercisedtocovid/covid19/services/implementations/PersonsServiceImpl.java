package com.exercisedtocovid.covid19.services.implementations;

import com.exercisedtocovid.covid19.classes.Person;
import com.exercisedtocovid.covid19.repositories.Repository;
import com.exercisedtocovid.covid19.services.IPersonsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonsServiceImpl implements IPersonsService {
    @Override
    public List<Person> getPersons() {
        return Repository.persons;
    }
}
