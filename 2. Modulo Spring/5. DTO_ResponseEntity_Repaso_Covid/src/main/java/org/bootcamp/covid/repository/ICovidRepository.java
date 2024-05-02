package org.bootcamp.covid.repository;

import org.bootcamp.covid.model.Person;
import org.bootcamp.covid.model.Symptom;

import java.util.Collection;
import java.util.List;

public interface ICovidRepository {
    List<Symptom> getSymptoms();
    Symptom findSymptomByName(String name);
    List<Person> getRiskPersons();
}
