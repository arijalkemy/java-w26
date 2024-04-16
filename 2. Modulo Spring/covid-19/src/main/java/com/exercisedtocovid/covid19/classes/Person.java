package com.exercisedtocovid.covid19.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Person {
    private String id;
    private String name;
    private String surname;
    private Integer age;
    private List<Symptom> symptoms;
}
