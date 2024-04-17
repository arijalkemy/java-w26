package bootcamp.bendezujonathan.covid.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import bootcamp.bendezujonathan.covid.model.Person;
import bootcamp.bendezujonathan.covid.repository.interfaces.IPersonRepository;
import bootcamp.bendezujonathan.covid.services.interfaces.IPersonService;

@Service
public class PersonService implements IPersonService {

    @Override
    public List<Person> findAll() {
        return IPersonRepository.findAll();
    }

    @Override
    public List<Person> findByEdadAndRisk(int age, int amountOfRisk) {
        return IPersonRepository.findAll()
                .stream()
                .filter(person -> person.isOlder(age) && person.hasMoreThanSymptoms(amountOfRisk))
                .toList();
    }

}
