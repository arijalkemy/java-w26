package org.example.ejerciciodeportistas.services.services.impl;

import org.example.ejerciciodeportistas.dto.PersonDto;
import org.example.ejerciciodeportistas.models.Person;
import org.example.ejerciciodeportistas.models.Sport;
import org.example.ejerciciodeportistas.services.IpersonServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServicesImpl implements IpersonServices {

    List<Person> persons;

    public PersonServicesImpl() {
        Person p1 = new Person("juan", "gonzalez", 25, new Sport("soccer", "medium"));
        Person p2 = new Person("pedro", "vargas", 25, new Sport("soccer", "medium"));
        Person p3 = new Person("maria", "alvarez", 25, new Sport("soccer", "medium"));

        persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
    }

    @Override
    public List<PersonDto> findPersons() {
        List<PersonDto> personDtos = new ArrayList<>();
        for (Person person : persons) {
            PersonDto personDto = new PersonDto(person.getName(), person.getLastname(), person.getSport().getName());
            personDtos.add(personDto);
        }
        return personDtos;
    }
}
