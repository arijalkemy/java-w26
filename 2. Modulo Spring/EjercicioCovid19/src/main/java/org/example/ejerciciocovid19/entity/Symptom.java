package org.example.ejerciciocovid19.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Symptom {
    private int code;
    private String symptomName;
    private int levelOfSeverity;
}
