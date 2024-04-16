package com.ejercicio.covid19.DTOs;

public class RiskPerson {
    private String name;
    private String lastName;
    private String symptom;

    public RiskPerson(String name, String lastName, String symptom) {
        this.name = name;
        this.lastName = lastName;
        this.symptom = symptom;
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

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
}
