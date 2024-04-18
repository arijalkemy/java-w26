package org.example.ejerciciocovid19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SymptomDTO {
    private int code;
    private String symptomName;
    private int levelOfSeverity;
}
