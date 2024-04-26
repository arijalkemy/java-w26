package com.Ejercicio.Deportistas.Service;

import com.Ejercicio.Deportistas.Entity.DTO.PersonDTO;
import com.Ejercicio.Deportistas.Entity.Person;
import com.Ejercicio.Deportistas.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class IPersonServiceImpl implements IPerson{
    @Autowired
    Repository repository;

    @Override
    public List<PersonDTO> getPersons() {
        List<PersonDTO> personDTOList = new ArrayList<>();
        for (Person person : Repository.personList) {
            PersonDTO personDTO = new PersonDTO();
            personDTO.setName(person.getName());
            personDTO.setLastName(person.getSurname());
            personDTO.setSport(person.getSport().getName());
            personDTOList.add(personDTO);
        }
        return personDTOList;
    }
}
