package com.example.Sintomas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonAndSymptom {
    private String personName;
    private String lastName;
    private String symptomName;
}
