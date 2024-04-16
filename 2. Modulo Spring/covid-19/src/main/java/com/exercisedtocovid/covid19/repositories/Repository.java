package com.exercisedtocovid.covid19.repositories;

import com.exercisedtocovid.covid19.classes.Person;
import com.exercisedtocovid.covid19.classes.Symptom;


import java.util.ArrayList;
import java.util.List;

public class Repository {
     public static List<Person> persons;
     public static List<Symptom> symptoms;

     static {
          symptoms = new ArrayList<>();
          persons = new ArrayList<>();

          Symptom headache = new Symptom("#001", "Headache", 2);
          Symptom backPain = new Symptom("#002", "Back pain", 1);
          Symptom insomnia = new Symptom("#003",  "Insomnia", 3);

          symptoms.add(headache);
          symptoms.add(backPain);

          persons.add(new Person("#A01", "Blas", "Bulacio", 62, List.of(headache, backPain, insomnia)));
          persons.add(new Person("#A01", "Blas", "DeRiesgo", 70, List.of(headache, insomnia)));
          persons.add(new Person("#A02", "Persona", "DolorDeCabeza", 18, List.of(headache, backPain)));
          persons.add(new Person("#A03", "Persona", "DolorDeEspalda", 65, List.of(backPain)));
     }

}
