package meli.bootcamp.covid19.services;

import meli.bootcamp.covid19.dto.PersonSymptomDto;
import meli.bootcamp.covid19.dto.mapper.Mapper;
import meli.bootcamp.covid19.entities.Person;
import meli.bootcamp.covid19.repositories.PersonRepository;
import meli.bootcamp.covid19.services.interfaces.ICrud;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonImpl implements ICrud<Person> {

    private final List<Person> persons;

    public PersonImpl() {
        this.persons = PersonRepository.persons;
    }

    @Override
    public List<Person> getAll() {
        return this.persons;
    }

    @Override
    public Person getOne(String name) {
        return this.persons
                .stream()
                .filter(person -> person.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<PersonSymptomDto> findRiskPerson() {
        return this.persons
                .stream()
                .filter(person -> person.getAge() >= 60)
                .map(Mapper::toPersonSymptomDto)
                .toList();
    }
}
