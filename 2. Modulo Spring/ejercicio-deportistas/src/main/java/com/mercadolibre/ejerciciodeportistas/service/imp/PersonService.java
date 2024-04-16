package com.mercadolibre.ejerciciodeportistas.service.imp;

import com.mercadolibre.ejerciciodeportistas.model.dto.SportPersonDTO;
import com.mercadolibre.ejerciciodeportistas.model.entity.Person;
import com.mercadolibre.ejerciciodeportistas.model.entity.Sport;
import com.mercadolibre.ejerciciodeportistas.service.IPersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements IPersonService {

    private List<Person> people;
    public PersonService() {
        people = new ArrayList<>(List.of(
                new Person("Franco", "Moises",21, new Sport("Soccer", "Hard"))
        ));

    }
    @Override
    public List<SportPersonDTO> findAll() {
        return people.stream()
                .map(p -> new SportPersonDTO(
                        p.getName(),
                        p.getLastName(),
                        p.getSport().getName()
                ))
                .toList();
    }
}
