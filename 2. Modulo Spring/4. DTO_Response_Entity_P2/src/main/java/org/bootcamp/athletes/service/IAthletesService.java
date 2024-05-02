package org.bootcamp.athletes.service;

import org.bootcamp.athletes.dto.PersonDTO;
import org.bootcamp.athletes.dto.SportDTO;

import java.util.List;

public interface IAthletesService {
    List<SportDTO> findSports();

    SportDTO findSportByName(String name);

    List<PersonDTO> findSportsPersons();
}
