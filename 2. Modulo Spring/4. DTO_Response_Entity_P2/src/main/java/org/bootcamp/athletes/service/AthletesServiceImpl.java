package org.bootcamp.athletes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.athletes.dto.PersonDTO;
import org.bootcamp.athletes.dto.SportDTO;
import org.bootcamp.athletes.model.Sport;
import org.bootcamp.athletes.repository.IAthletesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthletesServiceImpl implements IAthletesService {
    @Autowired
    IAthletesRepository athletesRepository;

    @Override
    public List<SportDTO> findSports() {
        return athletesRepository.getSports().stream()
                .map(sport -> new SportDTO(sport.getName(), sport.getLevel()))
                .toList();
    }

    @Override
    public SportDTO findSportByName(String name) {
        Sport sport = athletesRepository.getSportByName(name);
        return new SportDTO(sport.getName(), sport.getLevel());
    }

    @Override
    public List<PersonDTO> findSportsPersons() {
        return athletesRepository.getPersons().stream()
                .map(person -> new PersonDTO(person.getName(), person.getLastName(), person.getSport().getName()))
                .toList();
    }
}
