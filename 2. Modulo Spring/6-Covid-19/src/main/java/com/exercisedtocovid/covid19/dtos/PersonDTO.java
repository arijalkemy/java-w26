package com.exercisedtocovid.covid19.dtos;

import com.exercisedtocovid.covid19.classes.Symptom;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
public class PersonDTO implements Serializable {
    private String personName;
    private String personSurname;
    private Integer age;
    private List<Symptom> symptoms;
}
