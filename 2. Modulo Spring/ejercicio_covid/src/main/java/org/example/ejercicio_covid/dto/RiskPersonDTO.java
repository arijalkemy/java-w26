package org.example.ejercicio_covid.dto;

import org.example.ejercicio_covid.models.Symptom;

import java.util.*;

public class RiskPersonDTO {

    private String name;
    private String lastName;
    private Integer age;
    private List<Symptom> symptoms;

    public RiskPersonDTO( String name, String lastName, Integer age, List<Symptom> symptoms) {

        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.symptoms = symptoms;
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
