package com.spring.deportistas.services.services.impl;

import com.spring.deportistas.models.Person;
import com.spring.deportistas.models.Sport;
import com.spring.deportistas.models.dto.PersonSportDTO;
import com.spring.deportistas.repository.PersonsRepository;
import com.spring.deportistas.repository.PersonsSportsRepository;
import com.spring.deportistas.repository.SportsRepository;
import com.spring.deportistas.services.IPersonsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PersonsService implements IPersonsService {

    private final List<Person> persons;
    private final Map<String, String> personsSports;
    private final SportsRepository sportsMap;

    public PersonsService() {
        this.sportsMap = new SportsRepository();
        this.persons = new PersonsRepository().getPersons();
        this.personsSports = PersonsSportsRepository.personsSports;
    }

    @Override
    public List<PersonSportDTO> getAllPersonsSports() {
        List<PersonSportDTO> dtoArrayList = new ArrayList<>();

        for (Person person : this.persons) {
            String personKey = person.getName().toLowerCase() + "_" + person.getSurname().toLowerCase();
            String sportKey = personsSports.get(personKey);
            Sport currentSport = sportsMap.getSportsMap().get(sportKey);

            if (currentSport != null) {
                dtoArrayList.add(
                        new PersonSportDTO(personKey.replace('_', ' '),
                                currentSport.getName()));
            }

        }
        return dtoArrayList;
    }
}
