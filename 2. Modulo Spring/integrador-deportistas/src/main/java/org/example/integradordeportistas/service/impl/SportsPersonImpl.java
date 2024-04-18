package org.example.integradordeportistas.service.impl;

import org.example.integradordeportistas.dto.SportsPersonDTO;
import org.example.integradordeportistas.model.Person;
import org.example.integradordeportistas.model.Sport;
import org.example.integradordeportistas.repository.SportsPersonRepository;
import org.example.integradordeportistas.service.ISports;
import org.example.integradordeportistas.service.ISportsPerson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SportsPersonImpl implements ISportsPerson <SportsPersonDTO>, ISports<Sport> {


    // Injecting Dependencies
    private final SportsPersonRepository sportsPersonRepository;

    public SportsPersonImpl(SportsPersonRepository sportsPersonRepository){
        this.sportsPersonRepository = sportsPersonRepository;
    }

    @Override
    public List<Sport> findAll() {
        return sportsPersonRepository.getSports();
    }

    @Override
    public Sport find(String name) {
        Sport sportFinder = new Sport();
        for (Sport sport: sportsPersonRepository.getSports()){
            if (sport.getName().equals(name)){
                sportFinder = sport;
            }
        }
        return sportFinder;
    }

    @Override
    public List<SportsPersonDTO> findRelated() {

        List<SportsPersonDTO> sportsPersonDTOSList = new ArrayList<>();

        for (Person person : sportsPersonRepository.getPerson()){
            if (person.getSport() != null){
                SportsPersonDTO personDTO = new SportsPersonDTO(
                        person.getName() + " " + person.getLastName(),
                        person.getSport().getName()
                );
                sportsPersonDTOSList.add(personDTO);
            }
        }
        return sportsPersonDTOSList;
    }
}
