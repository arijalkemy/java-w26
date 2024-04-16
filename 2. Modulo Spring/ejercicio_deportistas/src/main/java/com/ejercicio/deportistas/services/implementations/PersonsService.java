package com.ejercicio.deportistas.services.implementations;

import com.ejercicio.deportistas.DTOs.SportPersonResponseDTO;
import com.ejercicio.deportistas.entities.Sport;
import com.ejercicio.deportistas.repository.implementations.PersonsRepository;
import com.ejercicio.deportistas.repository.implementations.SportsRepository;
import com.ejercicio.deportistas.services.interfaces.IPersonsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonsService implements IPersonsService {
    private PersonsRepository personsRepository = new PersonsRepository();
    private SportsRepository sportsRepository = new SportsRepository();

    @Override
    public List<SportPersonResponseDTO> getSportsPersons() {
        addSportsToPersons();
        return personsRepository.getAll()
                .stream()
                .map(
                        person -> new SportPersonResponseDTO(
                                person.getName(),
                                person.getLastName(),
                                person.getSport().getName())
                ).collect(Collectors.toList());
    }

    private void addSportsToPersons() {
        for (int i=0; i < personsRepository.getAll().size(); i++) {
            Sport sport = sportsRepository.getAll().get(i);
            personsRepository.getAll().get(i).setSport(sport);
        }
    }
}
