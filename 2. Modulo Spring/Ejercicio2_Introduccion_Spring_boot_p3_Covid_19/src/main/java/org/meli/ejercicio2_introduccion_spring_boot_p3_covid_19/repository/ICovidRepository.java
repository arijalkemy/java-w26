package org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.repository;

import org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.model.Person;
import org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.model.Symptom;

import java.util.Set;
import java.util.stream.Stream;

public interface ICovidRepository {
    public Set<Symptom> selectAllSymptoms();
    public Set<Symptom> filterBySymptoms(String symptom);
    public Set<Symptom> selectCriticalPeople();



}
