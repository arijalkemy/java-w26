package meli.bootcamp.deportistas.services;

import meli.bootcamp.deportistas.dto.PersonSportDto;
import meli.bootcamp.deportistas.dto.mapper.PersonSportMapper;
import meli.bootcamp.deportistas.entities.Person;
import meli.bootcamp.deportistas.repository.PersonRepository;
import meli.bootcamp.deportistas.services.interfaces.ICrud;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaImpl implements ICrud<Person> {

    List<Person> persons;

    public PersonaImpl() {
        persons = PersonRepository.PERSONS;
    }

    @Override
    public List<Person> getAll() {
        return this.persons;
    }

    @Override
    public Person getOne(String name) {
        return this.persons.stream()
                .filter(person -> person.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<PersonSportDto> getPersonsWithSport() {
        return this.persons.stream()
                .filter(person -> person.getSport() != null)
                .map(PersonSportMapper::toDto)
                .toList();
    }
}
