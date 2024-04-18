package org.example.integradorcovid.model;

import java.util.List;

public class Person {

    private String id;
    private String name;
    private String lastName;
    private int age;
    private List<Symptom> symptoms;


    public Person(String id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String id, String name, String lastName, int age, List<Symptom> symptoms) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.symptoms = symptoms;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }
}
