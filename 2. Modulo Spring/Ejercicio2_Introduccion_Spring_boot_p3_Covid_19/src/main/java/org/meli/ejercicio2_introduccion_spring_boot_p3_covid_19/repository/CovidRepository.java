package org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.repository;

import org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.model.Person;
import org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class CovidRepository implements ICovidRepository {
    private Set<Symptom> symptoms = new HashSet<>();
    private Set<Person> people = new HashSet<>();

    public CovidRepository() {
        this.getPersons();
        this.getSymptoms();
    }

    @Override
    public Set<Symptom> selectAllSymptoms() {
        return symptoms;
    }

    @Override
    public Set<Symptom> filterBySymptoms(String symptom) {
        return symptoms
                .stream()
                .filter(s -> s.getSymptom().equals(symptom))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Symptom> selectCriticalPeople() {
        symptoms.stream()
                .forEach(s -> {
                    s.getPersonsCritical().clear();
                    s.getPersons().stream().filter(p -> p.getAge() > 59).forEach(p -> s.getPersonsCritical().add(p));
                        }
                );
        return symptoms;
    }

    private void getSymptoms(){
        symptoms.add(new Symptom(1L, "Fever", "High", people, new HashSet<>()));
        symptoms.add(new Symptom(2L, "Cough", "Medium",people, new HashSet<>()));
        symptoms.add(new Symptom(3L, "Shortness of breath", "High",people, new HashSet<>()));
        symptoms.add(new Symptom(4L, "Fatigue", "Low",new HashSet<>(), new HashSet<>()));
        symptoms.add(new Symptom(5L, "Muscle or body aches", "Medium",people, new HashSet<>()));
        symptoms.add(new Symptom(6L, "Headache", "Medium",new HashSet<>(), new HashSet<>()));
        symptoms.add(new Symptom(7L, "New loss of taste or smell", "High",people, new HashSet<>()));
        symptoms.add(new Symptom(8L, "Sore throat", "Low",people, new HashSet<>()));
        symptoms.add(new Symptom(9L, "Congestion or runny nose", "Low",people, new HashSet<>()));
        symptoms.add(new Symptom(10L, "Nausea or vomiting", "Medium",people, new HashSet<>()));
        symptoms.add(new Symptom(11L, "Diarrhea", "Medium",people, new HashSet<>()));
    }
    private void getPersons(){
        people.add(new Person(1L, "John", "Doe", 65));
        people.add(new Person(2L, "Jane", "Smith", 68));
        people.add(new Person(3L, "Michael", "Johnson", 62));
        people.add(new Person(4L, "Emily", "Williams", 67));
        people.add(new Person(5L, "Christopher", "Brown", 60));
        people.add(new Person(6L, "Jessica", "Jones", 65));
        people.add(new Person(7L, "Daniel", "Garcia", 62));
        people.add(new Person(8L, "Ashley", "Miller", 68));
        people.add(new Person(9L, "Matthew", "Davis", 65));
        people.add(new Person(10L, "Amanda", "Martinez", 60));

    }
}
