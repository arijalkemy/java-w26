package com.Ejercicio.Covid.Service;

import com.Ejercicio.Covid.DTO.PersonDto;
import com.Ejercicio.Covid.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements  IPersonService {

    @Autowired
    Repository repository;

    @Override
    public List<PersonDto> searchRiskPerson() {
        return Repository.personList.stream()
                .filter(person -> person.getAge() >= 60)
                .map(person -> {
                    PersonDto personDto = new PersonDto();
                    personDto.setName(person.getName());
                    personDto.setSurname(person.getSurname());
                    personDto.setAge(person.getAge());
                    return personDto;
                })
                .collect(Collectors.toList());
    }
}
