package com.athletes.bootcamp.services.implementations;

import com.athletes.bootcamp.classes.Person;
import com.athletes.bootcamp.repositories.Repository;
import com.athletes.bootcamp.services.IPersonsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonsServiceImpl implements IPersonsService {
    @Override
    public List<Person> getPersons() {
        return Repository.persons;
    }
}
