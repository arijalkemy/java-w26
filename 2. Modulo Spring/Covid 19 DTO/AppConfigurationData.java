package org.example.api;

import org.example.api.entities.Person;
import org.example.api.entities.Symptom;
import org.example.api.entities.dto.RiskPersonDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class AppConfigurationData {
    public List<Person> personList() {
        return List.of(
                new Person("Daniel", "Martinez", 21),
                new Person("Camila", "Perez", 62),
                new Person("Diana", "Villa", 35),
                new Person("Camilo", "Gonzalez", 19),
                new Person("Diego", "Gomez", 64),
                new Person("Cesar", "Vargas", 74)
        );
    }

    @Bean
    public List<RiskPersonDTO> riskPerson() {
        List<Person> personList = personList();
        List<Symptom> symptomList = symptomList();
        int maxSymptoms = symptomList.size();
        Random r = new Random();
        List<RiskPersonDTO> riskPersonList = new ArrayList<>();
        for (Person person : personList) {
            int current = r.nextInt(maxSymptoms);
            Symptom symptom = symptomList.get(current);
            riskPersonList.add(
                    new RiskPersonDTO(person.getName(), person.getLastname(), person.getAge(), symptom.getName())
            );
        }
        return riskPersonList;
    }

    @Bean
    public List<Symptom> symptomList() {
        return List.of(
                new Symptom("Fiebre", 3),
                new Symptom("Tos", 2),
                new Symptom("Gripa", 1),
                new Symptom("Dolor estomacal", 1)
        );
    }
}
