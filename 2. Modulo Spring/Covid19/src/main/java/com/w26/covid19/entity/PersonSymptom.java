package com.w26.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonSymptom {
    private Person person;
    private Symptom symptom;
}
