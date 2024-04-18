package com.spring.covid19.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Person {
    private int id;
    private String name;
    private String lastname;
    private int age;
    private List<Symptom> symptoms;

    public Person(int id, String name, String lastname, int age, List<Symptom> symptoms) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.symptoms = symptoms;
    }
}
