package com.ej1p2.covid19.services.implementations;

import com.ej1p2.covid19.dto.PersonSymptomDTO;
import com.ej1p2.covid19.model.Person;
import com.ej1p2.covid19.services.IRiskPerson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiskPersonImpl implements IRiskPerson {

    @Override
    public List<PersonSymptomDTO> findRiskPersons() {
        List<PersonSymptomDTO> riskPersons = new ArrayList<>();
        List<Person> persons = new ArrayList<>();

        Person person1 = new Person(1, "Rami", "Sclerandi", 22);
        Person person2 = new Person(2, "Mateo", "Rivero", 71);
        Person person3 = new Person(3, "Marcos", "Belloti", 60);

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        for (Person person : persons) {
            if (person.getAge()>60) {
                PersonSymptomDTO dto = new PersonSymptomDTO(person.getFirstName(), person.getLastName());
                riskPersons.add(dto);
            }
        }

        return riskPersons;
    }
}
