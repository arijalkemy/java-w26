package com.exercisedtocovid.covid19.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Symptom {
    private String code;
    private String name;
    private Integer severityLevel;
}
