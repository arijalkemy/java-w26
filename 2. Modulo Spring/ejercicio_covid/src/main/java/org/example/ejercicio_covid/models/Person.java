package org.example.ejercicio_covid.models;

import java.util.*;

public class Person {
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private List<Symptom> symptoms= new ArrayList<>();;

    public Person(Long id, String name, String lastName, Integer age, List<Symptom> symptoms) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.symptoms = symptoms;
    }

    public Person(Long id, String name, String lastName, Integer age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }
}
