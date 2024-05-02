package org.bootcamp.covid.repository;

import org.bootcamp.covid.model.Person;
import org.bootcamp.covid.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CovidRepositoryImpl implements ICovidRepository {
    private static final List<Symptom> symphons = List.of(
            new Symptom("000123", "Fever", "High"),
            new Symptom("000124", "Cough", "Medium"),
            new Symptom("000125", "Headache", "Low"),
            new Symptom("000126", "Fatigue", "Medium"),
            new Symptom("000127", "Loss of taste or smell", "High"),
            new Symptom("000128", "Sore throat", "Low"),
            new Symptom("000129", "Shortness of breath", "High"),
            new Symptom("000130", "Muscle or body aches", "Medium")
    );

    private static final List<Person> persons = List.of(
            new Person("000001", "John", "Doe", 35, List.of(symphons.get(0), symphons.get(1), symphons.get(2))),
            new Person("000002", "Jane", "Doe", 60, List.of(symphons.get(3), symphons.get(4), symphons.get(5))),
            new Person("000003", "Alice", "Smith", 45, List.of(symphons.get(6), symphons.get(7))),
            new Person("000004", "Bob", "Johnson", 50, List.of()),
            new Person("000005", "Charlie", "Brown", 65, List.of(symphons.get(3), symphons.get(4), symphons.get(5))),
            new Person("000006", "David", "Davis", 70, List.of(symphons.get(6), symphons.get(7))),
            new Person("000007", "Eva", "Green", 65, List.of())
    );

    @Override
    public List<Symptom> getSymptoms() {
        return symphons;
    }

    @Override
    public Symptom findSymptomByName(String name) {
        return symphons.stream()
                .filter(symptom -> symptom.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Person> getRiskPersons() {
        return persons.stream().filter(person -> !person.getSymptoms().isEmpty() && person.getAge() >= 60).toList();
    }
}
