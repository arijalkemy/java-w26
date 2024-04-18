package com.spring.covid19.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SymptomDTO {
    private String name;
    private int severityLevel;

    public SymptomDTO(String name, int severityLevel) {
        this.name = name;
        this.severityLevel = severityLevel;
    }
}
