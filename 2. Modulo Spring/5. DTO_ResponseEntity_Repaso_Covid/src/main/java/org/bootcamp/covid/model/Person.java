package org.bootcamp.covid.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Person {
    private String id;
    private String name;
    private String lastName;
    private int age;
    private List<Symptom> symptoms;
}
