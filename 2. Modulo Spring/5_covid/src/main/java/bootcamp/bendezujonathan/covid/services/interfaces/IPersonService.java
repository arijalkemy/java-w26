package bootcamp.bendezujonathan.covid.services.interfaces;

import java.util.List;

import bootcamp.bendezujonathan.covid.model.Person;

public interface IPersonService {
    
    List<Person> findAll();

    List<Person> findByEdadAndRisk(int age, int amountOfRisk);
}
