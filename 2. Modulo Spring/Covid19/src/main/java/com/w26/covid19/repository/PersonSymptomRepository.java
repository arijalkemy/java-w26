package com.w26.covid19.repository;

import com.w26.covid19.entity.Person;
import com.w26.covid19.entity.PersonSymptom;
import com.w26.covid19.entity.Symptom;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;



@Repository
@Data
public class PersonSymptomRepository {
    private List<PersonSymptom> personSymptomList;

    final SymptomRepository symptomRepository;
    final PersonRepository personRepository;

    public PersonSymptomRepository(SymptomRepository symptomRepository, PersonRepository personRepository)
    {
        this.symptomRepository = symptomRepository;
        this.personRepository = personRepository;
        personSymptomList = new ArrayList<>();
        this.load();
    }

    public void load()
    {

        for (Person person: personRepository.getPersonList()) {
            Symptom sintoma = symptomRepository.getRandomSympt();
            PersonSymptom personSymptom = new PersonSymptom(person, sintoma);
            this.personSymptomList.add(personSymptom);
        }
    }
}

