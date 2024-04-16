package com.ej2p1.athletes.services.implementations;

import com.ej2p1.athletes.dto.SportPersonDTO;
import com.ej2p1.athletes.model.Person;
import com.ej2p1.athletes.services.IAthleteValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AthleteValidatorImpl implements IAthleteValidator {
    private List<Person> persons = new ArrayList<>();

    @Override
    public List<SportPersonDTO> findAthletes() {
        Person person1 = new Person("Santi", "Perez", 20);
        Person person2 = new Person("Roman", "Astore", 22);
        Person person3 = new Person("Agu", "Caceres", 31);
        Person person4 = new Person("Lucas", "Tarallo", 32);

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        Map<String, String> athleteAndSportName = new HashMap<>();

        athleteAndSportName.put("Santi Perez", "Tennis");
        athleteAndSportName.put("Roman Astore", "Football");
        athleteAndSportName.put("Agu Caceres", "Basketball");

        List<SportPersonDTO> athletes = new ArrayList<>();
        for (Person person : persons) {
            if (athleteAndSportName.containsKey(person.getFirstName()+" "+person.getLastName())) {
                SportPersonDTO dto = new SportPersonDTO();
                dto.setFirstName(person.getFirstName());
                dto.setLastName(person.getLastName());
                dto.setSportName(athleteAndSportName.get(person.getFirstName()+" "+person.getLastName()));
                athletes.add(dto);
            }
        }
        return athletes;
    }
}
