package meli.bootcamp.deportistas.services;

import meli.bootcamp.deportistas.entities.Person;
import meli.bootcamp.deportistas.repository.PersonRepository;
import meli.bootcamp.deportistas.repository.SportRepository;
import meli.bootcamp.deportistas.services.interfaces.ICrud;
import meli.bootcamp.deportistas.entities.Sport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportImpl implements ICrud<Sport> {

    List<Sport> sports;
    List<Person> persons;

    public SportImpl() {
        this.sports = SportRepository.SPORTS;
        persons = PersonRepository.PERSONS;
    }


    @Override
    public List<Sport> getAll() {
        return this.sports;
    }

    @Override
    public Sport getOne(String name) {
        return this.sports.stream().filter(sport -> sport.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

}
