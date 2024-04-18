package com.spring.covid19.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Symptom {
    private int code;
    private String name;
    private int severityLevel;

    public Symptom(int code, String name, int severityLevel) {
        this.code = code;
        this.name = name;
        this.severityLevel = severityLevel;
    }
}
