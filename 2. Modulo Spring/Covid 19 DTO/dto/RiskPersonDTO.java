package org.example.api.entities.dto;

import lombok.Getter;

@Getter
public class RiskPersonDTO {
    private final String name;
    private final String lastname;
    private final Integer age;
    private final String symptomName;

    public RiskPersonDTO(String name, String lastname, Integer age, String symptomName) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.symptomName = symptomName;
    }
}
