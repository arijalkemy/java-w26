package org.example.integradorcovid.repository;


import org.example.integradorcovid.model.Person;
import org.example.integradorcovid.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SymptomRiskRepository {

    private final List<Person> personList;
    private final List<Symptom> symptomsList;

    public SymptomRiskRepository(){
        personList = new ArrayList<>();
        symptomsList = new ArrayList<>();

        Symptom symptom1 = new Symptom("s1","Dolor de cabeza", "leve");
        symptomsList.add(symptom1);

        Symptom symptom2 = new Symptom("s2","Mareo", "medio");
        symptomsList.add(symptom2);

        Symptom symptom3 = new Symptom("s3","Gripe", "grave");
        symptomsList.add(symptom3);

        Symptom symptom4 = new Symptom("s4","Congestión", "leve");
        symptomsList.add(symptom4);

        Symptom symptom5 = new Symptom("s5","Escalofrío", "leve");
        symptomsList.add(symptom5);

        Symptom symptom6 = new Symptom("s6","Dolor de cuerpo", "medio");
        symptomsList.add(symptom6);

        Symptom symptom7 = new Symptom("s7","Dolor de muela", "grave");
        symptomsList.add(symptom7);

        Symptom symptom8 = new Symptom("s8","Dolor en la uña", "grave");
        symptomsList.add(symptom8);

        Symptom symptom9 = new Symptom("s9","Dolor en el pelo", "grave");
        symptomsList.add(symptom9);

        List<Symptom> symptoms1 = new ArrayList<>(){{
            add(symptom1);
            add(symptom2);
        }};

        List<Symptom> symptoms2 = new ArrayList<>(){{
            add(symptom3);
            add(symptom4);
            add(symptom5);
        }};
        List<Symptom> symptoms3 = new ArrayList<>(){{
            add(symptom7);
            add(symptom8);
        }};
        List<Symptom> symptoms4 = new ArrayList<>(){{
            add(symptom9);
            add(symptom1);
        }};



        Person person1 = new Person("p1","Della", "Rodríguez", 50, symptoms1);
        personList.add(person1);

        Person person2 = new Person("p2","Andrés", "Lugo", 60, symptoms2);
        personList.add(person2);

        Person person3 = new Person("p3","Felipe", "Rodríguez", 60, symptoms3);
        personList.add(person3);

        Person person4 = new Person("p4","Salomé", "Uribe", 60, symptoms4);
        personList.add(person4);

        Person person5 = new Person("p5","Tomas", "Todonte", 50);
        personList.add(person5);
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public List<Symptom> getSymptomsList() {
        return symptomsList;
    }
}
