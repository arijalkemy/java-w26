package com.ej1p2.covid19.dto;

public class PersonSymptomDTO {
    private String firstName;
    private String lastName;

    public PersonSymptomDTO() {
    }

    public PersonSymptomDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
